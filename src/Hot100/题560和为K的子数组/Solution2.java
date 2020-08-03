package Hot100.题560和为K的子数组;

public class Solution2 {

    public int subarraySum(int[] nums, int k) {
        int sum[] = new int[nums.length];
        sum[0] = nums[0];
        int count=0;
        if(sum[0] == k){
            count++;
        }
        for (int i = 1;i<sum.length;i++){
            sum[i] = sum[i-1]+nums[i];
            if(sum[i] == k){
                count++;
            }
        }
        for (int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(sum[j] - sum[i] == k){
                    count++;
                }
            }
        }
        return count;
    }
}
