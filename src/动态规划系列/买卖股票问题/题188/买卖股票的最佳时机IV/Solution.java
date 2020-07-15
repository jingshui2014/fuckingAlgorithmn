package 动态规划系列.买卖股票问题.题188.买卖股票的最佳时机IV;

public class Solution {

    public int maxProfit(int K, int[] prices) {

        if(prices == null || prices.length == 0){
            return 0;
        }

        int N = prices.length;

        if (K >= N / 2) {
            return maxProfit2(prices);
        }

        int[][][] dp = new int[prices.length][K + 1][2];

        for (int i = 0; i < N; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int j = 0; j <= K; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }

        for (int i = 1; i < N; i++) {
            for (int k = 1; k <= K; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);

                if (dp[i - 1][k - 1][0] != Integer.MIN_VALUE) {
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                } else {
                    dp[i][k][1] = dp[i - 1][k][1];
                }
            }
        }
        return dp[N - 1][K][0];
    }

    private int maxProfit2(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]){
                sum += (prices[i] - prices[i-1]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int i = so.maxProfit(2, new int[]{3,2,6,5,0,3});
        System.out.println(i);
    }
}
