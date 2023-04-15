package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        // https://leetcode.com/problems/two-sum/
        System.out.println(getTwoSumBruteForce(numbers, target));
        System.out.println(getTwoSumOnePassMap(numbers, target));

        // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
        System.out.println(getTwoSumSorted(numbers, target));


        // https://wentao-shao.gitbook.io/leetcode/two-pointers/1099.two-sum-less-than-k
        System.out.println(getTwoSumLessThanK(numbers, 10));
        numbers = new int[]{34, 23, 1, 24, 75, 33, 54, 8};
        target = 60;
        System.out.println(getTwoSumLessThanK(numbers, target));

        numbers = new int[]{10, 20, 30};
        target = 15;
        System.out.println(getTwoSumLessThanK(numbers, target));

        numbers = new int[]{-20, 1, 3, 4, 8, 11};
        System.out.println(getTwoSumBetweenTwoNumbers(numbers, 6, 9));

        numbers = new int[]{10, 20, 30, 40, 50, 60};
        System.out.println(getTwoSumBetweenTwoNumbers(numbers, 60, 100));


        // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
        // https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/


    }

    // here sorting is possible so time complexity reduces to O(nlog(n)) instead of O(n2) as in case of getTwoSumBruteForce
    private static int getTwoSumBetweenTwoNumbers(int[] numbers, int num1, int num2) {
        Arrays.sort(numbers); // This internally uses dual pivot quick sort which gives worst case time complexity of O(n2) so instead use count sort/ bucket sort
        int left = 0, right = 1, count = 0;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < num1) left++;
            else if (sum > num2) right--;
            else {
                left++;
                right++;
                count++;
            }
        }
        return count;
    }


    // here sorting is possible so time complexity reduces to O(nlog(n)) instead of O(n2) as in case of getTwoSumBruteForce
    private static int getTwoSumLessThanK(int[] numbers, int target) {
        Arrays.sort(numbers); // This internally uses dual pivot quick sort which gives worst case time complexity of O(n2) so instead use count sort/ bucket sort
        int left = 0, right = numbers.length - 1, sum = -1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                sum = numbers[left] + numbers[right];
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }


    // The Two Pointer approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static String getTwoSumSorted(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return Arrays.toString(new int[]{left, right});
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }
        }
        return null;
    }

    // Time Complexity: O(n2)
    // Space Complexity: O(1)
    // Here sorting is not possible since the indices data will be lost
    private static String getTwoSumBruteForce(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return Arrays.toString(new int[]{i, j});
                }
            }
        }
        return null;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static String getTwoSumOnePassMap(int[] numbers, int target) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            final int complement = target - numbers[i];
            if (store.containsKey(complement)) {
                return Arrays.toString(new int[]{i, store.get(complement)});
            }
            store.put(numbers[i], i);
        }
        return null;
    }
}
