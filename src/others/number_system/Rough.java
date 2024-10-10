package others.number_system;

public class Rough {

    public static void main(String[] args) {
        String xyz = "123";
        System.out.println(xyz.charAt(0));
        StringBuilder abc = new StringBuilder("456");
        System.out.println(abc.charAt(0));

        int decimal = 10;
        StringBuilder binary = new StringBuilder();

        // Loop until the decimal number is 0
        while (decimal > 0) {
            int remainder = decimal % 2; // Get the remainder
            binary.insert(0, remainder); // Prepend the remainder
            decimal = decimal / 2; // Update the decimal number
        }
        System.out.println(binary);
    }
}
