package Hot100.题11盛最多水的容器;

public class Solution2 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int value = (height[left]>=height[right] ? (right - left)*height[right--] : (right-left)*height[left++]);
            maxArea = Math.max(value,maxArea);
        }

        return maxArea;
    }
}
