package 动态规划系列.背包问题.背包实现最大价值;

/**
 * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
 * 其中第i个物品的重量为wt[i]，价值为val[i]，
 * 现在让你用这个背包装物品，最多能装的价值是多少？
 *
 * 举个简单的例子，输入如下：
 *
 * N = 3, W = 4
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 * 算法返回 6，选择前两件物品装进背包，总重量 3 小于W，可以获得最大价值 6。
 */

public class Solution {


    public int getMaxValue(int[] wt, int[] val, int N, int W) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {

                if (w - wt[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]]+val[i-1]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int maxValue = so.getMaxValue(new int[]{2, 1, 3}, new int[]{4, 2, 3}, 3, 4);
        System.out.println(maxValue);
    }
}
