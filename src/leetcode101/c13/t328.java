package leetcode101.c13;

//328. 奇偶链表
//        给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//
//        请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

/*
设置两个链表头，分别为奇数和偶数
每次更新链表指向下下个节点。
 */

public class t328 {
    public static ListNode oddEvenList(ListNode head) {
        if(head == null)return null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode even = p2;
        while (p2 != null && p2.next != null){
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }

//        while (p1 != null) System.out.println(p1.val);
        // while (p2 != null) System.out.println(p2.val);

//        p2.next = null;
        p1.next = even;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode t = head;
        t.next = new ListNode(2);
        t = t.next;
        t.next = new ListNode(3);
        t = t.next;
        t.next = new ListNode(4);
        t = t.next;
        t.next = new ListNode(5);
        oddEvenList(head);

    }
}
