package Hot100.题55跳跃游戏;

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i = 1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j]>=(i-j)){
                    dp[i] |=dp[j];
                }
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}
