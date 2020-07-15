package 动态规划系列.CSNOte.字符串编辑.题650只有两个键的键盘;

import java.util.Arrays;

public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = i / 2; j >= 1; j--) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + 2 + (i / j - 2));
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int i = so.minSteps(3);
        System.out.println(i);
    }
}
