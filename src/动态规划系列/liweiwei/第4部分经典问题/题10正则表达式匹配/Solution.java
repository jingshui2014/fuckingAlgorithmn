package 动态规划系列.liweiwei.第4部分经典问题.题10正则表达式匹配;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isMatch(String s, String p) {

        if (s == null && p == null) {
            return true;
        }
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()][p.length()];


        dp[0][0] = (s.charAt(0) == p.charAt(0)) | (p.charAt(0) == '.');


        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < p.length(); j++) {
                if(i>1){
                    dp[i][j] = dp[i][j] |
                            (dp[i - 1][j - 1] && ((s.charAt(i) == p.charAt(j))
                                    | (p.charAt(j) == '.')
                                    | ((p.charAt(j - 1) == s.charAt(i) || (p.charAt(j - 1) == '.')) && p.charAt(j) == '*')));
                }

                if (i == s.length() - 1 && j == p.length() - 1) {
                    return dp[i][j];
                }
                dp[i][j] = dp[i][j] | (dp[i][j - 1]);
            }
        }
        return dp[s.length() - 1][p.length() - 1];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        boolean match = so.isMatch("aa", "a*");
        System.out.println(match);
    }
}
