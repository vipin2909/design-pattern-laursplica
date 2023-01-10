package object_methods;

import java.util.Objects;

final class CaseInsesitiveString {
    private final String s;
    public CaseInsesitiveString(String str) {
        this.s = Objects.requireNonNull(str);
    }

    // @Broken -> violates symmetry
//    @Override
//    public boolean equals(Object o) {
//        if(o instanceof CaseInsesitiveString) {
//            System.out.println("IN CASE 2nd");
//            return s.equalsIgnoreCase(((CaseInsesitiveString) o).s);
//        }
//        if(o instanceof String) {
//            System.out.println("Inside Debugger"+s.equalsIgnoreCase((String) o));
//            return s.equalsIgnoreCase((String) o);
//        }
//        return false;
//    }


    @Override
    public boolean equals(Object o) {
//        System.out.println("Hello "+Boolean.valueOf(o instanceof CaseInsesitiveString));
//        assert o instanceof CaseInsesitiveString;
//        System.out.println((o.s).equalsIgnoreCase(s));
        return o instanceof CaseInsesitiveString && ((CaseInsesitiveString) o).s.equalsIgnoreCase(s);
    }

    @Override
    public String toString() {
        return "THIS " + s;
    }
}


public class CaseInsesitiveStringTest {
    public static void main(String[] args) {
//        String s = "polish";
        CaseInsesitiveString cis = new CaseInsesitiveString("Polish");
        CaseInsesitiveString cis2 = new CaseInsesitiveString("polish");
        // this method points to String equals method
//        System.out.println(s.equals(cis));
        // this method points to cis equals method
        System.out.println(cis.equals(cis2));
        System.out.println(cis2.equals(cis));

//       CaseInsesitiveString o = ((CaseInsesitiveString) cis).s.equalsIgnoreCase(s);
//       System.out.println(o);
    }

}
