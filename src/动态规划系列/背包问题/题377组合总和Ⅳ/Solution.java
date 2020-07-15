package 动态规划系列.背包问题.题377组合总和Ⅳ;

public class Solution {
    public int combinationSum4(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i - nums[j]>=0){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int i = so.combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(i);
    }

}
