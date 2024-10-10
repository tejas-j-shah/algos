package others.number_system;

public class Binary implements StringToDecimalConvertible,
                                IntToDecimalConvertible,
                                IntToDecimalCastable{

    // This will take a number and convert to Decimal
    @Override
    public int convertToDecimal(int num) {
        int decimal = 0;
        for(int i=0; num>0;i++){
            int remainder = num % 10;
            if (remainder == 1) {
                decimal += Math.pow(2, i);
            }
            num = num / 10;
        }
        return decimal;
    }


    // This will take binary and convert to Decimal
    @Override
    public int castToDecimal(int num) {
        int binary = 0b111101010101010101010101101;
        int decimal = binary;
        return decimal;
    }

    // This will take String and convert to Decimal
    @Override
    public int convertToDecimal(String num) {
        int decimal = 0;
        int length = num.length();
        for (int i = 0; i<length; i++){
            if (num.charAt(length - 1 - i) == '1'){
                decimal += Math.pow(2, i);
            }
        }
        return decimal;
    }
}
