package 动态规划系列.背包问题.题416分割等和子集;

public class Solution {

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }
        if (target % 2 != 0) {
            return false;
        }
        target/=2;
        boolean dp[][] = new boolean[nums.length][target + 1];
        if(nums[0] <= target){
            dp[0][nums[0]] = true; //不加也没关系
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i] > 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else if (j == nums[i]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
