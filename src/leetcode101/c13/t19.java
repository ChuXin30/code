package leetcode101.c13;

//19. 删除链表的倒数第 N 个结点
//        给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//        进阶：你能尝试使用一趟扫描实现吗？

/*
使用一个快慢指针
先让快指针 向前走n步
然后快慢指针同时出发，当快指针到达终点
慢指针到达倒数n个节点。
删除当前节点就行

感觉每次写链表边界都搞不清楚
要不要加头节点，到什么时候停止

 */

public class t19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode slow = pre;

        while (n > 0){
            fast = fast.next;
            n--;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return pre.next;
    }
}
