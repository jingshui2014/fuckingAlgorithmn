package 高频面试系列.判断回文链表.题234回文链表;

public class Solution {

    ListNode left = null;

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        left = head;
        return traverse(head);

    }

    private boolean traverse(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = traverse(head.next);
        if (res && left.val == head.val) {
            left = left.next;
            return true;
        }
        return false;
    }
//    double ID1 =0.769;
//    double VDS2 = 60;
//    double VGST = 900 -348;
//    double ID2 = 1.48;
//    double VDS1 = 30;
//
//    double r1 = 2*ID1*VDS2*(VGST - VDS2/2);
//    double r2 = 2*ID2*VDS1*(VGST-VDS1/2);
//        System.out.println(r1);
//        System.out.println(r2);
//    double R1 = 2*ID1*VDS2*(VGST - VDS2/2)-2*ID2*VDS1*(VGST-VDS1/2);
//
//        System.out.println(R1);
//
//    double R2 = ID1*ID2*(VDS1-VDS2);
//
//        System.out.println(R2);
//        System.out.println(R1/R2);
}
