package Hot100.题34在排序数组中查找元素的第一个和最后一个位置;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int left = findLeftBoundaryIndex(nums, target);
        int right = findRightBoundaryIndex(nums, target);
        return new int[]{left, right};
    }

    private int findLeftBoundaryIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        boolean flag = false;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                flag = true;
                right = middle;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return flag ? left:-1;
    }

    private int findRightBoundaryIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        boolean flag = false;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                flag = true;
                left = middle+1;
            } else if (nums[middle] > target) {
                right = middle ;
            } else {
                left = middle + 1;
            }
        }
        return flag ? left-1 : -1;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int leftBoundaryIndex = so.findRightBoundaryIndex(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(leftBoundaryIndex);
    }
}
