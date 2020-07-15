package domain;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayToTree {

    public static TreeNode convert(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.add(root);

        int k = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if(k < nums.length){
                    if(nums[k] != null){
                        head.left = new TreeNode(nums[k]);
                        queue.add(head.left);
                    }
                    k++;
                }
                if(k < nums.length) {
                    if(nums[k] != null) {
                        head.right = new TreeNode(nums[k]);
                        queue.add(head.right);
                    }
                    k++;
                }
                if(k == nums.length){
                    return root;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = convert(new Integer[]{1, 3,null,null,2});
        print(root);
    }

    public static void  print(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
}
