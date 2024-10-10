package others.number_system;

public class Decimal implements IntToBinaryConvertible,
                                StringToBinaryConvertible{

    @Override
    public String convertToBinary(int num) {
        return Integer.toBinaryString(num);
    }

    @Override
    public String convertToBinary(String num) {
        int number = convertStringToInt(num); // or use inbuilt Integer.parseInt(num);
        return convertToBinary(number);
    }

    // implement Integer.parseInt(String num)
    private int convertStringToInt(String num) {
        int decimal  = 0;
        final int length = num.length();
        for (int i = 0; i< length; i++){
            final int digit = num.charAt(length - 1 - i) - '0';
            decimal += digit * Math.pow(10, i);
        }
        return decimal;
    }
}
