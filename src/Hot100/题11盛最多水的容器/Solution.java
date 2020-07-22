package Hot100.题11盛最多水的容器;

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int i = 0;i<height.length;i++){
            int cur = height[i];
            int left = i-1;
            while (left>=0){
                if(cur<=height[left]){
                    maxArea = Math.max ((height[left] - cur)*(i-left),maxArea);
                }
                left--;
            }
            int right = i+1;
            while (right<height.length){
                if(cur<=height[right]){
                    maxArea = Math.max ((height[right] - cur)*(right-i),maxArea);
                }
                right++;
            }
        }
        return maxArea;
    }
}
