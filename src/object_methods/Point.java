package object_methods;

public class Point {
    private final int x;
    private final int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    public static void main(String[] args) {
        Point p = new Point(1, 10);
        Point p2 = new Point(1, 10);
        System.out.println(p.equals(p2));
        System.out.println(p2.equals(p));
    }
}
