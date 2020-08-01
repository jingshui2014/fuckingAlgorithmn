package Hot100.题309最佳买卖股票时机含冷冻期;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][3];
        for (int[] temp : dp) {
            Arrays.fill(temp, Integer.MIN_VALUE);
        }

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);

            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = dp[i - 1][1] + prices[i];

        }
        return Math.max( dp[prices.length - 1][0],dp[prices.length-1][2]);
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int i = so.maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);
    }
}
