package Hot100.题128最长连续序列;


import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int longestConsecutive(int[] nums) {

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int temp : nums) {
            map.put(temp, temp);
        }
        for (int i = 0; i < nums.length; i++) {

            int r = nums[i];
            while (map.containsKey(r + 1)) {
                r = r + 1;
            }
            map.put(nums[i], r);
            max = Math.max(max, r - nums[i] + 1);
        }
        return max;
    }
}
