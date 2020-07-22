package Hot100.题39组合总和;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return lists;
        }
        LinkedList<Integer> list = new LinkedList<>();
        dfs(candidates, target, 0, list);
        return lists;
    }

    public void dfs(int[] candidates, int target, int index, LinkedList<Integer> list) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], index, list);
                list.removeLast();
            }
        }
    }
}
