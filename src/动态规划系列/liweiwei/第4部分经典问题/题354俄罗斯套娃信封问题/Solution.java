package 动态规划系列.liweiwei.第4部分经典问题.题354俄罗斯套娃信封问题;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int[] dp = new int[envelopes.length];
        int maxValue = 0;

        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] != envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[j],dp[i]);
                }
            }
            dp[i]++;
            maxValue = Math.max(maxValue,dp[i]);
        }
        return maxValue;
    }
}
