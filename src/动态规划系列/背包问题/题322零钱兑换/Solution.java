package 动态规划系列.背包问题.题322零钱兑换;

import java.util.Arrays;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        if(dp[amount] == amount+1){
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int change = so.coinChange(new int[]{2}, 11);
        System.out.println(change);
    }
}
