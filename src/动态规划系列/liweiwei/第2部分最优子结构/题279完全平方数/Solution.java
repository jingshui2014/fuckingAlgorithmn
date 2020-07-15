package 动态规划系列.liweiwei.第2部分最优子结构.题279完全平方数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        List<Integer> list = getSquareNum(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < list.size() && list.get(j).intValue() <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - list.get(j)]+1);
            }
        }
        return dp[n];
    }

    public  List<Integer> getSquareNum(int n) {
        List<Integer> list = new ArrayList<>();
        int tempNum = 1;
        int preNum = 1;

        while (tempNum <= n) {
            list.add(tempNum);
            tempNum += preNum + 2;
            preNum = preNum + 2;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.numSquares(13));
    }
}
