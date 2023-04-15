package Arrays;

public class MaxDiff {

    /*private static int maxDifference(int[] arr) {
        int min = arr[0];
        int diff = -1;

        for (int j : arr) {
            if (j > min) {
                diff = Math.max(j - min, diff);
            } else {
                min = j;
            }
        }

        return diff;
    }*/

    private static int maxDifference(int[] arr) {
        int i = 0;
        int j = 1;
        int curr_diff = -1;

        while (i < j && j < arr.length) {
            if (arr[i] < arr[j]) {
                curr_diff = Math.max(curr_diff, arr[j] - arr[i]);
            } else {
                i = j;
            }
            j++;
        }
        return curr_diff;
    }

    // https://stackoverflow.com/questions/57325024/maximum-difference-in-an-array-not-passing-all-test-cases-in-hackerrank
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 10, 2, 4, 8, 1};
        System.out.println(maxDifference(arr1) == 8);

        int[] arr2 = {7, 9, 5, 6, 3, 2};
        System.out.println(maxDifference(arr2) == 2);

        int[] arr3 = {3};
        System.out.println(maxDifference(arr3) == -1);

        int[] arr4 = {-3, -2};
        System.out.println(maxDifference(arr4) == 1);

        int[] arr5 = {90, 91, 2, 150, 4, 95};
        System.out.println(maxDifference(arr5) == 148);

        int[] arr6 = {20, 18, 45, 78, 3, 65, 55};
        System.out.println(maxDifference(arr6) == 62);

        int[] arr7 = {20, 8, 45, 78, 3, 65, 55};
        System.out.println(maxDifference(arr7) == 70);

        int[] arr8 = {1, 2, 3, 4, 10};
        System.out.println(maxDifference(arr8) == 9);

        int[] arr9 = {1, 10, -10, 4, 8};
        System.out.println(maxDifference(arr9) == 18);

        int[] arr10 = {5, 8, 12, 1, 9};
        System.out.println(maxDifference(arr10) == 8);
    }
}
