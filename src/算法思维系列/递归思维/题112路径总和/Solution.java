package 算法思维系列.递归思维.题112路径总和;

import domain.TreeNode;

/**
 * simple
 */

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum){

        if(root == null){
            return false;
        }else if(root.left == null && root.right == null && sum == root.val){
            return true;
        }else if(root.left == null && root.right == null && sum != root.val){
            return false;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
