package 高频面试系列.如何运用二分查找算法.题875爱吃香蕉的珂珂;

/**
 * 二分法
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int maxSpeed = 1;
        for (int i = 0; i < piles.length; i++) {
            maxSpeed = Math.max(maxSpeed, piles[i]);
        }
        int left = 1;
        int right = maxSpeed + 1;
        int mid = left;
        while (left < right) {
            mid = (left+right)/2;
            if (isOk(piles, mid, H)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    private boolean isOk(int[] piles, int speed, int H) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile / speed + (pile % speed == 0 ? 0 : 1));
            if (hours > H) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int i = so.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6);
        System.out.println(i);
    }
}
