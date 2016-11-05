import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander on 05/11/2016.
 */
public class TwoPassMap {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            int remainder = target - nums[i];
            if (map.containsKey(remainder) && remainder != nums[i]){
                return new int[]{i, map.get(remainder)};
            }

        }
        throw new IllegalArgumentException("No two sum found");
    }
}
