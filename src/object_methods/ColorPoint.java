package object_methods;

import java.util.Objects;

enum Color {
    RED,
    BLUE,
    OARNGE,
    PINK,
    GREEN,
    YELLOW,
}
//public class ColorPoint extends Point {
//
//    private final Color color;
//    public ColorPoint(int x, int y, Color color) {
//        super(x, y);
//        this.color = color;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if(!(o instanceof ColorPoint)) {
//            return false;
//        }
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }
//
//    public static void main(String[] args) {
//        Point p = new Point(10, 20);
//        ColorPoint colorPoint = new ColorPoint(10,20, Color.RED);
//
//        // true because colorPoint object is instance of Point class
//        System.out.println(p.equals(colorPoint));
//
//        // false because p is not an instance of ColorPoint ans also p don't have Color instance variable
//        System.out.println(colorPoint.equals(p));
//    }
//}


// by using composition this issue get resolved

public class ColorPoint {
    private Point point;
    private final Color color;
    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ColorPoint)) {
            return false;
        }

        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    public static void main(String[] args) {
        ColorPoint cp1 = new ColorPoint(10, 20, Color.RED);
        ColorPoint cp2 = new ColorPoint(10, 20, Color.RED);
        ColorPoint cp3 = new ColorPoint(10, 20, Color.RED);
        System.out.println(cp1.equals(cp2));
        System.out.println(cp2.equals(cp3));
        System.out.println(cp1.equals(cp3));
    }
}
