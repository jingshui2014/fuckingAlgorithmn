package 算法思维系列.二分法;

public class BinarySearch {

    static int binarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left<= right){
            mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,2,2,3},2));
    }
}
