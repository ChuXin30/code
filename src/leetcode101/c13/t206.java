package leetcode101.c13;

//206. 反转链表
//        给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

public class t206 {
//    迭代
    public ListNode reverseList1(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
    }

//    递归

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
