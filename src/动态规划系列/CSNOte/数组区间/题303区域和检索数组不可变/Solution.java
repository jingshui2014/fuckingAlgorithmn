package 动态规划系列.CSNOte.数组区间.题303区域和检索数组不可变;

public class Solution {
    private int[] sums;
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(i == 0){
                sums[i] = nums[i];
            }else{
                sums[i] += sums[i-1]+ nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0){
            return sums[j];
        }else{
            return sums[j] - sums[i];
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution(new int[]{-2,0,3,-5,2,-1});
        int i = so.sumRange(0, 2);
        System.out.println();
    }
}
