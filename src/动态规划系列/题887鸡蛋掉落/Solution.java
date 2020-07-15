package 动态规划系列.题887鸡蛋掉落;

public class Solution {

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];

        //楼层为0
        for (int i = 0; i <= K; i++) {
            dp[0][i] = 0;
        }

        //楼层为1
        dp[1][0] = 0;
        for (int i = 1; i <= K; i++) {
            dp[1][i] = 1;
        }

        //鸡蛋为0
        for (int i = 2; i <= N; i++) {
            dp[i][0] = 0;
        }

        //鸡蛋为1
        for (int i = 2; i <= N; i++) {
            dp[i][1] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                //初始化，最多为i，i表示楼层数
                dp[i][j] = i;
                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[i-k][j],dp[k-1][j-1])+1);
                }
            }
        }
        return dp[N][K];
    }
}
