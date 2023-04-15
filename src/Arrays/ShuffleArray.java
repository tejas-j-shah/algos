package Arrays;

public class ShuffleArray {

    /** <a href="https://www.geeksforgeeks.org/shuffle-2n-integers-a1-b1-a2-b2-a3-b3-bn-without-using-extra-space/?ref=rp">...</a> **/
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8};
        // int[] brr = { 1, 5, 2, 6, 3, 7, 4, 8 };
        printShuffledArray(arr);
        shuffleArrayInPlace(arr);
    }

    private static void shuffleArrayInPlace(int[] arr) {
        for (int i=0, k= arr.length/2 ; checkIfValid(i, k, arr.length) ; i++, k++) {
            System.out.print( arr[i] );
            System.out.print( arr[k] );
        }
    }

    private static boolean checkIfValid(int i, int k, int length) {
        return (i<length/2 && k<length);
    }

    private static void printShuffledArray(int[] arr) {
        for (int i=0, k= arr.length/2 ; checkIfValid(i, k, arr.length) ; i++, k++) {
            System.out.print( arr[i] );
            System.out.print( arr[k] );
        }
    }
}
