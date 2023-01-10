package builder_joushua_bloch;


import java.lang.ref.Cleaner;

class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {
        int numJunkPiles ;
        public State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // Invoked by close method or cleaner
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }

    }

    // The state of this room, shared with our Clenable
    private final State state;
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }
    @Override
    public void close() {
        cleanable.clean();
    }
}
public class Adult {
    public static void main(String[] args) {
        try(Room myRoom = new Room(7)) {
            System.out.println("Goodbye");
        }
    }
}
