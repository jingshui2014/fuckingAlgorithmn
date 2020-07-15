package 动态规划系列.背包问题.题494目标和;

/**
 * 枚举 回溯
 */
public class Solution3 {

    private int count = 0;

    public int findTargetSumWays(int[] nums, int S) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        findTargetSumWays(nums, 0, S);
        return count;
    }

    private void findTargetSumWays(int[] nums, int index, int s) {
        if (index == nums.length && s == 0) {
            count++;
            return;
        }
        if (index == nums.length) {
            return;
        }
        findTargetSumWays(nums,index+1,s+nums[index]);
        findTargetSumWays(nums,index+1,s-nums[index]);
    }


    public static void main(String[] args) {
        Solution3 so = new Solution3();
        int targetSumWays = so.findTargetSumWays(new int[]{0, 4, 6, 0, 3, 2, 6, 9, 4, 1
        }, 3);
        System.out.println(targetSumWays);
    }
}
