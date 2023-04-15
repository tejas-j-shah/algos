package Arrays;

public class ZeroFilledSubarray {
    private static long findZeroFilledSubs(int[] numbers) {
        int i = 0, n;
        long count = 0;
        while (i < numbers.length) {
            if (numbers[i] == 0) {
                int p = i + 1;
                while (p < numbers.length && numbers[p] == 0) {
                    p++;
                }
                n = p - i;
                // count += Math.pow(2, n) - 1; // this will hold true if all combinations are expected
                count = count + ((long) n * (n + 1) / 2);
                i = p + 1;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 0, 0, 2, 0, 0, 4};
        System.out.println(findZeroFilledSubs(numbers));

        numbers = new int[]{0, 0, 0, 2, 0, 0};
        System.out.println(findZeroFilledSubs(numbers));
    }
}
