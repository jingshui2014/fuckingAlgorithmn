package Hot100.题46全排列;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> lists = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return lists;
        }
        LinkedList<Integer> list = new LinkedList<>();
        dfs(nums, list);
        return lists;
    }

    public void dfs(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, list);
            list.removeLast();
        }
    }
}
