package 动态规划系列.背包问题.题474一和零;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        if ((m == 0 && n == 0) || strs == null || strs.length == 0) {
            return 0;
        }

        int[][][] dp = new int[m + 1][n + 1][strs.length];
        for (int i = NumOfZero(strs[0]); i < m + 1; i++) {
            for (int j = NumOfOne(strs[0]); j < n + 1; j++) {
                dp[i][j][0] = 1;
            }
        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 1; k < strs.length; k++) {
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k - 1]);
                    int lenOfZero = NumOfZero(strs[k]);
                    int lenOfOne = NumOfOne(strs[k]);
                    if (i - lenOfZero >= 0 && j - lenOfOne >= 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k],(dp[i - lenOfZero][j - lenOfOne][k - 1])+1);
                    }
                }
            }
        }
        return dp[m][n][strs.length-1];
    }


    private int NumOfZero(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }

    private int NumOfOne(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int maxForm = so.findMaxForm(new String[]{"10", "0", "1"}, 1, 1);
        System.out.println(maxForm);
    }
}
