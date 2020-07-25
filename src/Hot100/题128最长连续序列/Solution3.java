package Hot100.题128最长连续序列;


public class Solution3 {
    public int longestConsecutive(int[] nums) {

        int max = 0;
        UF uf = new UF(nums);
        for (int temp : nums) {
            uf.union(temp, temp + 1);
        }
        for (int temp : nums) {
            max = Math.max(max,uf.find(temp)-temp+1);
        }
        return max;
    }
}
