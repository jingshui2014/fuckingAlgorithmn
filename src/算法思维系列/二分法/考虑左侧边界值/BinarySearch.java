package 算法思维系列.二分法.考虑左侧边界值;

public class BinarySearch {

    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                 right =  mid;
            } else if (nums[mid] > target) {
                right = mid ;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if(left == nums.length) return -1;
        return nums[left] != target ? -1:left;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 2, 2, 3}, 1));
    }
}
