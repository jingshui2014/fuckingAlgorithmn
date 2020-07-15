package 动态规划系列.liweiwei.第4部分经典问题.题20三角形最小路径和;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        List<Integer> endList = triangle.get(triangle.size() - 1);

        int[][] dp = new int[triangle.size()][endList.size()];


        for (int i = 0; i < endList.size(); i++) {
            dp[triangle.size() - 1][i] = endList.get(i);
        }
        List<Integer> curList = endList;
        for (int i = triangle.size() - 2; i >= 0; i--) {
            curList = triangle.get(i);
            for (int j = 0; j < curList.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                dp[i][j] += curList.get(j);
            }
        }
        return dp[0][0];
    }
}
