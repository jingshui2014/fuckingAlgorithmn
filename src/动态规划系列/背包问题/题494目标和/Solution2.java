package 动态规划系列.背包问题.题494目标和;

/**
 * 动态规划
 */
public class Solution2 {

    public int findTargetSumWays(int[] nums, int S) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum < S) {
            return 0;
        }

        int[][] dp = new int[nums.length][2 * sum + 1];

        if (nums[0] != 0) {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        } else {
            dp[0][nums[0]+sum] = 2;
        }


        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {

                if (j - nums[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] < 2 * sum + 1) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
            }
        }
        return dp[nums.length - 1][sum + S];
    }

    public static void main(String[] args) {
        Solution2 so = new Solution2();
        int targetSumWays = so.findTargetSumWays(new int[]{0,0,1
        }, 1);
        System.out.println(targetSumWays);
    }
}
