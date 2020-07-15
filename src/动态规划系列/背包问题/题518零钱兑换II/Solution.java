package 动态规划系列.背包问题.题518零钱兑换II;

public class Solution {


    public int waysToChange(int n) {

        int[] nums = new int[]{1,5,10,25};

        int[][] dp = new int[nums.length][n+1];

        for(int i = 0;i<nums.length;i++){
            dp[i][0] = 1;
        }

        for (int j = nums[0];j<=n;j+=nums[0]){
            dp[0][j] = 1;
        }


        for(int i = 1;i<nums.length;i++){
            for(int j = 1;j<=n;j++){

                if(j-nums[i]>=0){
                    dp[i][j] += dp[i][j-nums[i]];
                }
                dp[i][j] +=  dp[i-1][j];
            }
        }

        return dp[nums.length-1][n] % 1000000007;
    }

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if(j - coins[i] >=0){
                    dp[j] += dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        int change = so.waysToChange(9);
        System.out.println(change);
    }
}
