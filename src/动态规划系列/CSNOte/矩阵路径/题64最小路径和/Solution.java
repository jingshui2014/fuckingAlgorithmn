package 动态规划系列.CSNOte.矩阵路径.题64最小路径和;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];

        int P = 0;
        int Q = 1;

        dp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[P][i] = dp[P][i - 1] + grid[P][i];
        }

        for (int i = 1; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if(j-1>=0){
                    dp[Q][j] = Math.min(dp[P][j], dp[Q][j - 1]) + grid[i][j];
                }else {
                    dp[Q][j] = dp[P][j] + grid[i][j];
                }
            }

            P= Q;
            Q = 1- Q;
        }

        return dp[Q][n - 1];
    }

    public static void main(String[] args) {
        Solution so  = new Solution();
        so.minPathSum(new   int[][]{
                {1,3,1},{1,5,1},{4,2,1}
        });
    }

}
