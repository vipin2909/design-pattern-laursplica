package object_methods;


class Text {
    int size = 10;
}
class A implements Cloneable {
    int x, y;
    public Text text = new Text();
    public A(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
            A a = (A)super.clone();
            a.text = new Text();
            a.text.size = text.size;
            return a;
    }

}

class B extends A implements Cloneable {
    int p;
    public B(int x, int y, int p) {
        super(x, y);
        this.p = p;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        B b = (B)super.clone();
        b.text = new Text();
        b.text.size = text.size;
        return b;
    }
}
public class InheritClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B(10, 20, 30);
        A a = new A(30, 50);
        B bClone = (B) b.clone();
        A aClone = (A) a.clone();
        a.text.size = 12;
        a.x = 20;
        b.p = 90;
        b.text.size = 1000;
        System.out.println(aClone.text.size+" "+aClone.x);
        System.out.println(bClone.text.size+" "+bClone.x);
    }
}
