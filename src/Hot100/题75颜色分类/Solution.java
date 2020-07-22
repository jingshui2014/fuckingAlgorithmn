package Hot100.题75颜色分类;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > right) {
                return;
            }

            while (i <= right && nums[i] == 2) {
                swap(nums, i, right--);
            }
            if (nums[i] == 0) {
                swap(nums, i, left++);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = new int[]{1, 1, 2};
        so.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
