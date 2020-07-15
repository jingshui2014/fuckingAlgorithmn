package 数据结构系列.单调队列.题239滑动窗口最大值;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * 维持一个单调递减的队列
 */
class MonotomicQueue {
    LinkedList<Integer> list = new LinkedList<>();

    public void push(int value) {
        while (!list.isEmpty() && list.getLast() < value) {
            list.removeLast();
        }
        list.addLast(value);
    }

    public Integer max() {
        return list.getFirst();
    }

    public Integer pop(int value) {
        if (!list.isEmpty() && list.getFirst() == value) {
            return list.removeFirst();
        } else {
            return null;
        }
    }
}

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int left = -1;
        int[] answer = new int[nums.length - k + 1];
        int index = 0;

        MonotomicQueue queue = new MonotomicQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i - left <= k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                left++;
                answer[index++] = queue.max();

                //pop窗口最左边的元素，虽然可能已经不在队列里了
                queue.pop(nums[i - k + 1]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] ints = so.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(ints));
    }
}
