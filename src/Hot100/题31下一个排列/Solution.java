package Hot100.题31下一个排列;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int right = nums.length - 1;
        while (right - 1 >= 0 && nums[right - 1] >= nums[right]) {
            right--;
        }
        if (right == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int left = right - 1;
        while (right + 1 < nums.length && nums[right + 1] > nums[left]) {
            right++;
        }
        swap(nums, left, right);
        reverse(nums, left + 1, nums.length - 1);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        so.nextPermutation(new int[]{1});
    }
}
