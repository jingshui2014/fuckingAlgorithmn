package 数据结构系列.刷题思路指南.题105从前序与中序遍历序列构造二叉树;

import domain.ArrayToTree;
import domain.TreeNode;

public class Solution {

    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length!=inorder.length){
            return null;
        }
        return buildTree(preorder,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if(end < start){
            return null;
        }

        int rootValue = preorder[index];
        TreeNode subRoot = null;
        for (int i = start; i <= end; i++) {
            if (rootValue == inorder[i]) {
                subRoot = new TreeNode(rootValue);
                index++;
                subRoot.left = buildTree(preorder, inorder, start, i - 1);
                subRoot.right = buildTree(preorder, inorder, i + 1, end);
            }
        }
        return subRoot;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        TreeNode treeNode = so.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        ArrayToTree.print(treeNode);
    }
}
