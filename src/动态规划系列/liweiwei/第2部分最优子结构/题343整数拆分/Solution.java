package 动态规划系列.liweiwei.第2部分最优子结构.题343整数拆分;

import java.util.Arrays;

public class Solution {

    public int integerBreak(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int i = so.integerBreak(3);
        System.out.println(i);
    }
}
