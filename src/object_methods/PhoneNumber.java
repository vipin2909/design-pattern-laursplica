package object_methods;

import java.lang.constant.Constable;
import java.util.Objects;



enum Size {
    SMALL,
    MEDIUM,
    LARGE,
    HUGE,
}
public class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = randomCheck(areaCode, 999, "area code");
        this.prefix = randomCheck(prefix, 999, "prefix");
        this.lineNum = randomCheck(lineNum, 9999, "line num");
    }

    private static short randomCheck(int value, int max, String arg) {
        if(value < 0 || value > max) {

            // IllegalArgument () -> arg + ": " + value -> defines break point
            throw new IllegalArgumentException(arg + ": " + value);
        }
        return (short)value;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof PhoneNumber)) {
            return false;
        }

        PhoneNumber phoneNumber = (PhoneNumber) o;
        return phoneNumber.lineNum == lineNum && phoneNumber.prefix == prefix
                && phoneNumber.areaCode == areaCode;
    }

    // Typical hashCode Method
//    @Override
//    public int hashCode() {
//        int result = 0;
//        result = Short.hashCode(areaCode);
//        result = 31 * result + Short.hashCode(lineNum);
//        result = 31 * result + Short.hashCode(prefix);
//
//        return result;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, lineNum, prefix);
    }



    public static void main(String[] args) {
        PhoneNumber ph = new PhoneNumber(1, 2, 3);
        PhoneNumber ph1 = new PhoneNumber(1, 2, 3);
//        PhoneNumber ph2 = new PhoneNumber(1000, 122222, 9090909);
//        System.out.println(ph.equals(ph1));

        System.out.println(Size.HUGE);

//        System.out.println(Boolean.valueOf(ph.hashCode() == ph1.hashCode()) + ": " + ph.hashCode());
    }

}
