package Hot100.题114二叉树展开为链表;

import domain.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        subFlatten(root);
    }

    public TreeNode subFlatten(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = subFlatten(root.left);
        TreeNode right = subFlatten(root.right);

        root.left = null;

        if (left != null) {
            root.right = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
        return root;
    }
}
