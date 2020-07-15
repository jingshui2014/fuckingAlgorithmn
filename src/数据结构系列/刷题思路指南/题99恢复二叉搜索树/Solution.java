package 数据结构系列.刷题思路指南.题99恢复二叉搜索树;

import domain.ArrayToTree;
import domain.TreeNode;

class Solution {

    TreeNode node1 = null;
    TreeNode node2 = null;
    int count = 0;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        recoverTree2( root);
        if(count == 1){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }
    public void recoverTree2(TreeNode root) {
        if(root == null) return ;
        recoverTree2(root.left);
        if(pre!=null && pre.val > root.val ){
            if(count == 0){
                count++;
                node1 = pre;
                node2 = root;
            }else{
                int temp = node1.val;
                node1.val = root.val;
                root.val = temp;
                count++;
                return;
            }
        }
        pre = root;
        recoverTree2(root.right);
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        so.recoverTree(ArrayToTree.convert(new Integer[]{1,3,null,null,2}));
    }
}