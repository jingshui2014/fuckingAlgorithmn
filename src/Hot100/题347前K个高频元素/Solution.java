package Hot100.题347前K个高频元素;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }



        int curIndex = 0;
        int start = 0;
        int end = nums.length - 1;
        while (curIndex != k) {
            curIndex = partition(nums, start, end);
            if(curIndex > k){
                partition(nums,start,curIndex);
            }else if(curIndex < k){

            }
        }

        PriorityQueue queue = new PriorityQueue();
//        queue.add()

        return null;

    }

    private int partition(int[] nums, int start, int end) {
        int curTemp = nums[end];
        int pre = start - 1;
        for (int i = start; i <= end; i++) {
            if (nums[i] < curTemp) {
                pre++;
                swap(nums, pre, i);
            }
        }
        swap(nums, pre + 1, end);
        return pre + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {

        Solution so = new Solution();
        System.out.println(so.partition(new int[]{9, 7, 1, 2, 3}, 0, 4));
    }
}
