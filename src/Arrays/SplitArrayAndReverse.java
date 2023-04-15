package Arrays;

import java.util.Arrays;
public class SplitArrayAndReverse {

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12};
        for (int i=0, j=array.length-1;i<array.length/2 || j>array.length/2; i++,j--) {
            array[i] = array[i]^array[j];
            array[j] = array[i]^array[j];
            array[i] = array[i]^array[j];
        }
        System.out.println("transformed array is -->" + Arrays.toString(array));

        array = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        int splitValue = 5;
        for (int k = 0; isCriteriaMet(array, splitValue, k); k++) {
            int i=k*splitValue, j=i+splitValue-1;
            while(i<j) {
                array[i] = array[i]^array[j];
                array[j] = array[i]^array[j];
                array[i] = array[i]^array[j];
                i++;
                j--;
            }
        }
        System.out.println("transformed array is -->" + Arrays.toString(array));
    }

    private static boolean isCriteriaMet(int[] array, int splitValue, int k) {
        return (k + 1) * splitValue <= array.length;
    }

}
