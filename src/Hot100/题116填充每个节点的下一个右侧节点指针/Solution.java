package Hot100.题116填充每个节点的下一个右侧节点指针;

public class Solution {

    public Node connect(Node root) {
        connect2( root.left, root.right);
        return root;
    }

    public void connect2( Node rootLeft, Node rootRight) {
        if (rootLeft == null || rootRight == null) {
            return;
        }
        rootLeft.next = rootRight;
        connect2(rootLeft.left, rootLeft.right);
        connect2(rootRight.left, rootRight.right);
        connect2(rootLeft.right,rootRight.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Solution so = new Solution();
        so.connect(root);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
