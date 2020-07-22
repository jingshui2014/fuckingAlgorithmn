package Hot100.题142环形链表II;

import 高频面试系列.判断回文链表.题234回文链表.ListNode;

/**
 * 递归 自顶向下
 */
public class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode otherHead = slow.next;
        slow.next = null;
        otherHead = sortList(otherHead);
        head = sortList(head);

        ListNode temp1 = head;
        ListNode temp2 = otherHead;
        ListNode root = new ListNode(-1);
        ListNode cur = root;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                cur.next = temp1;
                temp1 = temp1.next;
            } else {
                cur.next = temp2;
                temp2 = temp2.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        if (temp1 != null) {
            cur.next = temp1;
        } else if (temp2 != null) {
            cur.next = temp2;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode temp = head;
        for (int i = 3; i >= 1; i--) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        Solution so = new Solution();
        head = so.sortList(head);
        System.out.println(head);
    }

}
