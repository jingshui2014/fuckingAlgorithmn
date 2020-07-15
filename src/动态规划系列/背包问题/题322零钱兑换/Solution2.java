package 动态规划系列.背包问题.题322零钱兑换;

import java.util.Arrays;

public class Solution2 {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[][] dp = new int[coins.length + 1][amount + 1];

        Arrays.fill(dp[0],amount+1);

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        if(dp[coins.length][amount] == amount+1){
            return -1;
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        Solution2 so = new Solution2();
        int change = so.coinChange(new int[]{1,2,5}, 11);
        System.out.println(change);
    }
}
