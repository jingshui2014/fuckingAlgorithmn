package 动态规划系列.打家劫舍.题337打家劫舍III;

import domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if(map.containsKey(root)){
            return map.get(root);
        }
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        val = Math.max(val, rob(root.left) + rob(root.right));
        map.put(root,val);
        return val;
    }
}
