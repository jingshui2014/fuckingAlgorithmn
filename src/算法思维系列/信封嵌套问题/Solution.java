package 算法思维系列.信封嵌套问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 单位最长递增子序列的变种，注意排序规则，hard级别
 */
public class Solution {

    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        return findMaxIncreSubsequence(envelopes);
    }

    private int findMaxIncreSubsequence(int[][] envelopes) {

        int n = envelopes.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
        }
        int answer = 0;
        for (int i = 0;i<n;i++){
            answer = Math.max(answer,dp[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int maxIncreSubsequence = so.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
        System.out.println(maxIncreSubsequence);
    }
}
