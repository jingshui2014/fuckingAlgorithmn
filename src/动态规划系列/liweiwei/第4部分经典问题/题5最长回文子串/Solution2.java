package 动态规划系列.liweiwei.第4部分经典问题.题5最长回文子串;

/**
 * 动态规划
 */
public class Solution2 {
    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        int start = 0, end = 0;
        int maxLength = end - start + 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (i + 1 <= j - 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }

                if (dp[i][j] && (j - i + 1 > maxLength)) {
                    start = i;
                    end = j;
                    maxLength = end - start + 1;
                }
            }
        }
        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        Solution2 so = new Solution2();
        String babad = so.longestPalindrome("abacab");
        System.out.println(babad);
    }
}
