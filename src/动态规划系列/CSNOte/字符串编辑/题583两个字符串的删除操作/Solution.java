package 动态规划系列.CSNOte.字符串编辑.题583两个字符串的删除操作;

public class Solution {
    public int longestSubsequence(String word1, String word2) {

        if (word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) {
            return 0;
        }

        int[][] dp = new int[word1.length()][word2.length()];


        for (int i = 0; i < word2.length(); i++) {
            if (i == 0) {
                dp[0][0] = word1.charAt(i) == word2.charAt(i) ? 1 : 0;
            } else {
                if (dp[0][i - 1] == 1) {
                    dp[0][i] = dp[0][i - 1];
                } else {
                    dp[0][i] = word1.charAt(0) == word2.charAt(i) ? 1 : 0;
                }
            }
        }
        for (int i = 1; i < word1.length(); i++) {
            if (dp[i - 1][0] == 1) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = word1.charAt(i) == word2.charAt(0) ? 1 : 0;
            }
        }

        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[word1.length() - 1][word2.length() - 1];
    }

    public int minDistance(String word1, String word2){
        int res = longestSubsequence(word1,word2);
        System.out.println(res);
        return (word1.length()+word2.length())-2*res;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int i = so.minDistance("a", "ab");
        System.out.println(i);
    }
}
