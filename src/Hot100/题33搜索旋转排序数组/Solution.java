package Hot100.题33搜索旋转排序数组;

public class Solution {

    public int search(int[] nums, int target) {

        if(nums==null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int reverseIndex = 0;
        //二分法先找到旋转的位置
        while (left <= right) {
            int middle = (left + right) / 2;
            if (middle - 1 >= 0 && nums[middle - 1] > nums[middle]) {
                reverseIndex = middle;
                break;
            }
            if (middle + 1 < nums.length && nums[middle] > nums[middle + 1]) {
                reverseIndex = middle + 1;
                break;
            }
            if (nums[left] >= nums[middle]) {
                right = middle - 1;
            } else if (nums[right] < nums[middle]) {
                left = middle + 1;
            }else {
                //没有旋转
                 return binaryFind(nums,reverseIndex,nums.length-1,target);
            }
        }
        int res  = binaryFind(nums,0,reverseIndex-1,target);
        if(res!=-1){
            return res;
        }else {
            return binaryFind(nums,reverseIndex,nums.length-1,target);
        }
    }

    private int binaryFind(int[] nums, int start, int end, int target) {

        int middle = 0;
        while (start <= end) {
            middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }else if(nums[middle]>target){
                end = middle-1;
            }else {
                start = middle+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int search = so.search(new int[]{1,3,5}, 0);
        System.out.println(search);
    }
}
