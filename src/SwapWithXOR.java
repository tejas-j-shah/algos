public class SwapWithXOR {

    public static void main(String[] args) {

        int num1 = 15151515;
        int num2 = num1;
        swapIntegers(num1,num2);
        swapInts(num1,num2);
    }

    private static void swapInts (int num1, int num2) {
        System.out.println("swapInts starts");
        System.out.println("Before swap num1 is " + num1 + " and num2 is " + num2);
        if (num1 == num2) {
            System.out.println("They point to the same location hence cant be swapped");
        }else {
            num1 = num1 ^ num2;
            num2 = num1 ^ num2;
            num1 = num1 ^ num2;
            System.out.println("After swap num1 is " + num1 + " and num2 is " + num2);
        }
        System.out.println("swapInts ends");
    }

    private static void swapIntegers (Integer num1, Integer num2) {
        System.out.println("swapIntegers starts");
        System.out.println("Before swap num1 is " + num1 + " and num2 is " + num2);
        if (num1 == num2) {
            System.out.println("They point to the same location hence cant be swapped");
        }else {
            num1 = num1 ^ num2;
            num2 = num1 ^ num2;
            num1 = num1 ^ num2;
            System.out.println("After swap num1 is " + num1 + " and num2 is " + num2);
        }
        System.out.println("swapIntegers ends");
    }
}
