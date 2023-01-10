package object_methods;


// cloning hashTable
public class HashTableClone implements Cloneable {

    // implementing a HashTable and clone method inside a HashTable
    private Entry[] buckets = new Entry[10];

    String newLine = System.lineSeparator();

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // Recursively deepCopying the linked list headed by this Entry
        Entry deepCopy() {
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }

        @Override
        public String toString() {
            return "Key="+key+", Value="+value+", Next -> "+next;
        }

    }

    @Override
    public HashTableClone clone() {
        try {
            HashTableClone result = (HashTableClone) super.clone();
            result.buckets = new Entry[buckets.length];
            for(int i = 0; i < buckets.length; i++) {
                if(buckets[i] != null) {
                    result.buckets[i] = buckets[i].deepCopy();
                }
            }
            return result;
        }
        catch(CloneNotSupportedException e) {
            // create any break point if want
            throw new AssertionError();
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < buckets.length; i++) {
            if(buckets[i] != null) {
                sb.append(buckets[i].toString()).append(newLine);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HashTableClone hashTableClone = new HashTableClone();
        Entry r11 = new Entry(101, 1, null);
        Entry r12 = new Entry(102, 2, null);
        r11.next = r12;

        Entry r21 = new Entry(101, 1, null);
        Entry r22 = new Entry(102, 2, null);
        Entry r23 = new Entry(103, 3, null);
        r21.next = r22;
        r22.next = r23;


        hashTableClone.buckets[0] = r11;
        hashTableClone.buckets[1] = r21;

        HashTableClone hashTableClone1 = hashTableClone.clone();
        hashTableClone.buckets[0].next = null;
        hashTableClone.buckets[1].next.next = null;
        System.out.println(hashTableClone1);
        System.out.println(hashTableClone);

    }


}


//        [1, 10, 2] -> [2, 20, 3] -> [3, 30, null];
//
//        [11, 10, 2] -> [2, 20, 3] -> [3, 30, null];
//
//        [21, 10, 2] -> [2, 20, 3] -> [3, 30, null];
//
//        [31, 10, 2] -> [2, 20, 3] -> [3, 30, null];
//
//        [41, 10, 2] -> [2, 20, 3] -> [3, 30, null];


// (1, 10, 2) -> (2, 20, 3) -> (3, 30, null) -> break

// this is deep copy execution format
