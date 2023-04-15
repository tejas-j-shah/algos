package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 problem 1: https://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-2/
 problem 2: https://www.geeksforgeeks.org/duplicates-in-an-array-in-on-time-and-by-using-o1-extra-space-set-3/?ref=rp
 problem 3: https://www.geeksforgeeks.org/count-frequencies-elements-array-o1-extra-space-time (same as problem 2)
 problem 4: https://www.geeksforgeeks.org/counting-frequencies-of-array-elements/ (Another variant of problem 3)
 */

/** * Java Program to find duplicate elements in an array. In this program, you * will learn two solution to find duplicate elements in integer array e.g. * brute force, by using HashSet data structure. * * @author java67 */
    public class DuplicatesFromArray{ public static void main(String[] args) {
        int[] withDuplicates = { 1, 6, 3, 1, 3, 6, 6 };
        Set<Integer> duplicates = findDuplicates(withDuplicates);
        System.out.println("input array is : " + Arrays.toString(withDuplicates));
        System.out.println("Duplicate elements found in array are : " + duplicates);

        // now calling our generic method to find duplicates

        String[] myArray = { "ab", "cd", "ab", "de", "cd" };
        System.out.println("input string array is : " + Arrays.toString(myArray));
        getDuplicates(myArray);

        printRepeating(withDuplicates, withDuplicates.length);
    }


    /** * Complexity of this solution is O(n^2) * * @param input * @return */

    public static Set<Integer> findDuplicates(int[] input) {
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if (input[i] == input[j] && i != j) {
                    // duplicate element found
                    duplicates.add(input[i]); break;
                }
            }
        }
        return duplicates;
    }
    /** * Generic method to find duplicates in array.
     * Complexity of this method is * O(n) because we are using HashSet data structure. * * @param array * @return */
    public static <T extends Comparable<T>> void getDuplicates(T[] array) {
        Set<T> dupes = new HashSet<>();
        for (T i : array) {
            if (!dupes.add(i)) {
                System.out.println("Duplicate element in array is : " + i);
            }
        }
    }

    /** Solution 3 is below with TC as O(n) and SC as O(1)
     * This approach works because all elements are in the range from 0 to n-1
     * and arr[i]/n would be greater than 1 only if a value “i” has appeared more than once.
     * So, the input array can be used as a HashMap
     * However be aware of the restriction of elements here **/
    static void printRepeating(int[] arr, int n)
    {
        // First check all the values that are present in an array then go to that
        // values as indexes and increment by the size of array
        for (int i = 0; i < n; i++)
        {
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Now check which value exists more than once by dividing with the size of array
        for (int i = 0; i < n; i++)
        {
            if ((arr[i] / n) >= 2)
                System.out.println(i + " ");
        }
    }
}
