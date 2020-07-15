package 动态规划系列.打家劫舍.题213打家劫舍II;

public class Solution {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length  == 1){
            return nums[0];
        }else if( nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(rob2(nums,0,nums.length-2),rob2(nums,1,nums.length-1));
    }

    public int rob2(int[] nums,int start,int end) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[end-start+2];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i < end-start+2; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i+start-1]);
        }
        return dp[end-start+1];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int rob = so.rob(new int[]{1,2,3,1});
        System.out.println(rob);
    }
}
