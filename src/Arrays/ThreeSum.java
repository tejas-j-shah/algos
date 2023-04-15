package Arrays;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        // https://leetcode.com/problems/3sum/
        System.out.println(getThreeSumBruteForce(numbers, target));
        System.out.println(getThreeSumTwoPassMap(numbers, target));

        numbers = new int[]{0, 0, 0};
        System.out.println(getThreeSumBruteForce(numbers, target));
        System.out.println(getThreeSumTwoPassMap(numbers, target));

        // when array is sorted
        numbers = new int[]{-4, -1, -1, 0, 1, 2};
        System.out.println(getThreeSumSorted(numbers, target));

        numbers = new int[]{-1, 2, 1, -4};
        target = 1;
        System.out.println(getThreeSumLesserCloseToK(numbers, target));

        numbers = new int[]{-1, 0, 1, 2, -1, -4};
        target = 2;
        System.out.println(getThreeSumLesserCloseToK(numbers, target));

        // https:leetcode.com/problems/3sum-closest/
        numbers = new int[]{-1, 2, 1, -4};
        target = 1;
        System.out.println(getThreeSumGreaterCloseToK(numbers, target));

        // https:leetcode.com/problems/3sum-closest/
        numbers = new int[]{1, 1, -1};
        target = 2;
        System.out.println(getThreeSumGreaterCloseToK(numbers, target));

        // https:leetcode.com/problems/3sum-closest/
        numbers = new int[]{0, 0, 0};
        target = 1;
        System.out.println(getThreeSumGreaterCloseToK(numbers, target));
    }

    // Time Complexity: O(n3)
    // Space Complexity: O(1)
    private static Set<String> getThreeSumBruteForce(int[] numbers, int target) {
        Set<String> output = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == target) {
                        List<Integer> elements = new ArrayList<>(3);
                        elements.add(numbers[i]);
                        elements.add(numbers[j]);
                        elements.add(numbers[k]);
                        Collections.sort(elements);// So there are no duplicates
                        output.add(Arrays.toString(elements.toArray()));
                    }
                }
            }
        }
        return output;
    }


    // Time Complexity: O(n2)
    // Space Complexity: O(n)
    private static Set<String> getThreeSumTwoPassMap(int[] numbers, int target) {
        Map<Integer, Integer> store = new HashMap<>();
        Set<String> output = new HashSet<>();
        // Pass one
        for (int number : numbers) {
            store.put(number, store.getOrDefault(number, 0) + 1);
        }
        // Pass Two
        for (int i = 0; i < numbers.length; i++) {
            store.put(numbers[i], store.get(numbers[i]) - 1);
            for (int j = i + 1; j < numbers.length && j != i; j++) {
                store.put(numbers[j], store.get(numbers[j]) - 1);
                final int complement = target - (numbers[i] + numbers[j]);
                if (store.containsKey(complement) && store.get(complement) > 0) {
                    List<Integer> elements = new ArrayList<>(3);
                    elements.add(numbers[i]);
                    elements.add(numbers[j]);
                    elements.add(complement);
                    Collections.sort(elements);
                    output.add(Arrays.toString(elements.toArray()));
                }
            }
        }
        return output;
    }

    // // Time Complexity: O(n2)
    // The space complexity used here is O(m)
    // but since it’s used for storing the answers it’s not calculated in the space complexity.
    // So the space complexity is O(1).
    private static Set<String> getThreeSumSorted(int[] numbers, int target) {
        Set<String> output = new HashSet<>();
        Arrays.sort(numbers); // If array is sorted then it saves O(nlogn) in Time complexity
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            while (left < right) {
                if (numbers[i] + numbers[left] + numbers[right] == target) {
                    List<Integer> elements = new ArrayList<>();
                    elements.add(numbers[i]);
                    elements.add(numbers[left]);
                    elements.add(numbers[right]);
                    output.add(Arrays.toString(elements.toArray()));
                    left++;
                    right--;
                } else if (numbers[i] + numbers[left] + numbers[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return output;
    }

    private static int getThreeSumLesserCloseToK(int[] numbers, int target) {
        Arrays.sort(numbers);
        int sum = -1;
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            while (left < right) {
                final int complement = numbers[left] + numbers[right] + numbers[i];
                if (complement < target) {
                    sum = complement;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sum;
    }

    private static int getThreeSumGreaterCloseToK(int[] numbers, int target) {
        Arrays.sort(numbers);
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            while (left < right) {
                final int complement = numbers[left] + numbers[right] + numbers[i];
                final int abs = Math.abs(Math.abs(complement) - target);
                if (complement < target) {
                    if (abs < Math.abs(sum - target)) {
                        sum = complement;
                        left++;
                    }
                } else {
                    if (abs > Math.abs(sum - target)) {
                        sum = complement;
                        right--;
                    }
                }
            }
        }
        return sum;
    }
}
