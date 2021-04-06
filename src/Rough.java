import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rough {

    public static void main(String[] args ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input */

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        int search = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(name.split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i= array.length-1; i>0; i--) {
            if (array[i] == search) {
                System.out.println("Position= " + (i+1)); // considering 1 indexed array
                break;
            }
        }
    }
}
