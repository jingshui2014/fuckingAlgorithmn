package 动态规划系列.背包问题.题494目标和;

/**
 * 转换成0-1背包问题
 */
public class Solution {

    public int findTargetSumWays(int[] nums, int S) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }

        if (S > target || (target + S) % 2 != 0) {
            return 0;
        }

        target = (S + target) / 2;
        int[][] dp = new int[nums.length][target + 1];


        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (count == 1) {
                    count = 2;
                } else {
                    count *= 2;
                }
            }
            dp[i][0] = count;
        }
        if (nums[0] <= target && nums[0] != 0) {
            dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {

                dp[i][j] = dp[i - 1][j];

                if (j - nums[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int targetSumWays = so.findTargetSumWays(new int[]{1, 1, 1, 1, 1
        }, 3);
        System.out.println(targetSumWays);
    }
}
