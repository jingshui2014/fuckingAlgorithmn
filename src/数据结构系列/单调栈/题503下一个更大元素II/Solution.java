package 数据结构系列.单调栈.题503下一个更大元素II;

import java.util.Stack;

public class Solution {

    /**
     * 使用单调栈，不是循环数组的时候
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {

        int[] answer = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() || stack.peek() < nums[i]) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return answer;
    }

    /**
     * 使用单调栈，是循环数组的时候
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements2(int[] nums) {

        int[] answer = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < nums[i % nums.length]) {
                stack.pop();
            }
            answer[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % nums.length]);
        }
        return answer;
    }
}
