package others.number_system;

public class Hexadecimal implements StringToDecimalConvertible {

    @Override
    public int convertToDecimal(String num) {
        int decimal = 0;
        final int length = num.length();
        for (int i = 0; i< length; i++) {
            decimal += getHexChar(num.charAt(length-1-i)) * Math.pow(16, i);
        }
        return decimal;
    }

    private int getHexChar(char hexChar) {
        if (hexChar >= '0' && hexChar <= '9') {
            return hexChar - 48;
        } else if  (hexChar >= 'A' && hexChar <= 'F') {
            return hexChar - 'A' + 10;
        } else if (hexChar >= 'a' && hexChar<= 'f'){
            return hexChar - 'a' + 10;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Hexadecimal().convertToDecimal("3EF"));
    }
}
