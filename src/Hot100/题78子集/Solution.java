package Hot100.题78子集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        if(nums == null || nums.length == 0){
            return lists;
        }
        LinkedList<Integer> list = new LinkedList<>();
        lists.add(new ArrayList<>(list));
        dfs(nums,0,list);
        return lists;
    }
    public void dfs(int[] nums,int index,LinkedList<Integer> list){
        if(lists.size() == nums.length){
            return;
        }
        for(int i = index;i<nums.length;i++){
            list.add(nums[i]);
            lists.add(new ArrayList<>(list));
            dfs(nums,i+1,list);
            list.removeLast();
        }
    }
}
