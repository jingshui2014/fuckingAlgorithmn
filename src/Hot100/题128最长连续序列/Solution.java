package Hot100.题128最长连续序列;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {

        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int temp : nums) {
            set.add(temp);
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            int r = nums[i];
            while (set.contains(r + 1)) {
                r = r + 1;
            }
            max = Math.max(max, r - nums[i]+1);
        }
        return max;
    }
}
