package 数据结构系列.二叉搜索树操作集.题450删除二叉搜索树中的节点;

import domain.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode min = findMin(root);
            root.val = min.val;
            root.right = deleteNode(root.right,min.val);
        }
        if (root.val < key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val > key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode findMin(TreeNode root){
        if(root == null){
            return null;
        }
        while (root.left!=null){
            root = root.left;
        }
        return root;
    }
}
