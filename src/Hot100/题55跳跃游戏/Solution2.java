package Hot100.题55跳跃游戏;

public class Solution2 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int maxDistance = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(maxDistance >=i){
                maxDistance = Math.max(maxDistance,nums[i]+i);
            }else {
                return false;
            }
        }
        return true;
    }
}
