package Hot100.题4寻找两个正序数组的中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (nums1 == null || nums1.length == 0) {
            if (len2 % 2 == 0) {
                return (nums2[len2 / 2] + nums2[len2 / 2 + 1]) / 2;
            } else {
                return nums2[len2 / 2 + 1];
            }
        }
        if (nums2 == null || nums2.length == 0) {
            if (len1 % 2 == 0) {
                return (nums1[len1 / 2] + nums1[len1 / 2 + 1]) / 2;
            } else {
                return nums1[len1 / 2 + 1];
            }
        }
        int restCount = (len1 + len2 + 1) / 2;
        int start1 = 0;
        int start2 = 0;
        int end1 = nums1.length - 1;
        int end2 = nums2.length - 1;
        int middle1 = 0;
        int middle2 = 0;
        while (restCount > 0) {
            middle1 = (start1 + end1) / 2;
            middle2 = (start2 + end2) / 2;
            if (nums1[middle1] < nums2[middle2]) {
                if (middle1 - start1 + 1 >= restCount) {
                    int tempIndex = start1 + restCount - 1;
                    if (((len1 + len2) & 0x01) != 0) {
                        return nums1[tempIndex];
                    } else {
                        
                    }

                } else {
                    restCount -= (middle1 - start1 + 1);
                }
                start1 = middle1 + 1;
                end2 = middle2;
            } else if (nums1[middle1] > nums2[middle2]) {
                if (middle2 - start2 + 1 == restCount) {
                    int tempIndex = start2 + restCount - 1;
                    if (((len1 + len2) & 0x01) != 0) {
                        return nums2[tempIndex];
                    } else {
                        int temp = 0;
                        if (nums1[start1 - 1] > nums2[tempIndex]) {
                            temp = start1 - 2 >= 0 ? Math.max(nums1[start1 - 2], nums2[tempIndex]) : nums2[tempIndex];
                            return (temp + nums1[start1 - 1]) / 2;
                        } else {
                            temp = tempIndex - 1 >= 0 ? Math.max(nums1[start1 - 1], nums2[tempIndex - 1]) : nums2[start1 - 1];
                            return (temp + nums2[tempIndex]) / 2;
                        }
                    }
                } else {
                    restCount -= (middle2 - start2 + 1);
                }

                start2 = middle2 + 1;
                end1 = middle1;
            } else {
                end1 = middle1;
                end2 = middle2;
                restCount /= 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        double medianSortedArrays = so.findMedianSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        System.out.println(medianSortedArrays);
    }
}
