package leetcode101.c13;

//83. 删除排序链表中的重复元素
//        存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//
//        返回同样按升序排列的结果链表。

/*
使用一个hashmap来保存出现过的值，
当遇到出现过的值，将这个节点的前一个元素，指向这个节点的后面的元素
 */

import java.util.HashSet;

public class t83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(head.val);
        ListNode p = head;
        ListNode pre = head;
        p = p.next;
        while (p != null){
            if(hashSet.contains(p.val)) {
                pre.next = p.next;
                p = pre.next;
            }else {
                hashSet.add(p.val);
                pre = pre.next;
                p = p.next;
            }
        }
        return head;
    }
}
/*
排好序的不需要使用hashset
由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，因此我们只需要对链表进行一次遍历，就可以删除重复的元素。

 */
class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
