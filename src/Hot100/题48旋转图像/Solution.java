package Hot100.题48旋转图像;

public class Solution {
    public void rotate(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int m = nums.length;
        int n = nums[0].length;
        for(int i = 0;i<(m+1)/2;i++){
            for(int j = i;j<n-i*2;j++){
                int pre = nums[i][j];

                int c = j;
                int r = n - 1 - i;

                while (c != i || r != j) {
                    int temp = nums[c][r];
                    nums[c][r] = pre;
                    pre = temp;

                    int tempIndex = c;
                    c = r;
                    r = n-1-tempIndex;
                }
                nums[i][j] = pre;
            }
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        so.rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
    }
}
