package 动态规划系列.liweiwei.第4部分经典问题.题300最长上升子序列;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 0;
            for (int j = i - 1; j >= 0; j--) {
                 if(nums[i] > nums[j]){
                     dp[i] = Math.max(dp[i],dp[j]);
                 }
            }
            dp[i]++;
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}
