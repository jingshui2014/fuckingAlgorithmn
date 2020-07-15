package 动态规划系列.打家劫舍.题198打家劫舍I;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return nums[nums.length];
    }
}
