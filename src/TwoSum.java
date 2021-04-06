import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // https://leetcode.com/problems/two-sum/
    public static void main(String[] args) {
        /*int[] nums = {2,7,11,15};
        int target = 9;*/
        /*int[] nums = {3,2,4};
        int target = 6;*/
        int[] nums = {3,3};
        int target = 6;
        Map<Integer, Integer> data = new HashMap<>();

        /*for (int i=0;i<nums.length;i++) {
            data.put(nums[i], i);
        }
        for (int i=0;i<nums.length;i++) {
            int complement = target - nums[i];
            if (data.get(complement) != null && data.get(complement) != i) {
                System.out.println("Combo is --> [" + i + "," + data.get(complement) + "]");
                break;
            }
        }*/

        //Above 2 pass map can be combined to 1 pass map as below:::
        for ( int i=0; i<nums.length;i++) {
            int complement = target - nums[i];
            if (data.get(complement) != null && data.get(complement) != i) {
                System.out.println("Combo is --> [" + data.get(complement) + "," + i + "]");
                break;
            }
            data.put(nums[i], i);
        }
    }
}
