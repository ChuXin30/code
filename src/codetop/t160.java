package codetop;

//160. 相交链表
//        给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
//
//        图示两个链表在节点 c1 开始相交：

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class t160 {
//    哈希表
//    对暴力解法的一个优化方案是：先将其中一个链表存到哈希表中，此时再遍历另外一个链表查找重复结点只需 O(1)O(1) 时间
//
//            pythonjavacpp

    public class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> s = new HashSet<>();
            for (ListNode p = headA; p != null; p = p.next) {
                s.add(p);
            }
            for (ListNode p = headB; p != null; p = p.next) {
                if (s.contains(p))
                    return p;
            }
            return null;
        }
    }

//    栈
//    两个链表从公共结点开始后面都是一样的，若是我们顺着链表从后向前查找，很容易就能查找到链表的公共结点（第一个不相同的结点的下一个结点即所求）
//
//    那么如何从后向前查找呢？不难想到要使用栈
//
//            pythonjavacpp

    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Deque<ListNode> s1 = new ArrayDeque<ListNode>(), s2 = new ArrayDeque<ListNode>();
            for (ListNode p = headA; p != null; p = p.next)
                s1.addLast(p);
            for (ListNode p = headB; p != null; p = p.next)
                s2.addLast(p);
            ListNode ans = null;
            while (!s1.isEmpty() && !s2.isEmpty() && s1.peekLast() == s2.peekLast()) {
                s1.pollLast();
                ans = s2.pollLast();
            }
            return ans;
        }
    }

//    计算长度
//    前面的几个方法或是时间，或是空间，不满足题目要求的 O(n)O(n) 时间复杂度，且仅用 O(1)O(1) 内存
//
//    前面栈的解法中提到，从后向前很容易查找，那么能不能从前向后呢？若是两链表等长，那自然是可以的，指针同步后移，当遇到公共结点时两指针就会相遇，但若链表不等长那就不行了，两个指针可能会指向不同的公共结点，也就无法确定一个结点是否是公共结点。
//
//    由此，我们可以想到，能不能把两个链表变成等长的链表呢？显然若两链表不等长，那么长的链表的前 n 个结点（n 是长链表比短链表多的结点数）显然不可能是公共结点。而剩余部分两链表是等长的，自然就可以按照顺序同步后移的方法查找公共结点。
//
//    不过，为确定两链表长度差，得先遍历两链表确定长度
//
//            pythoncppcjava

    public class Solution3 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int s1 = 0, s2 = 0;
            for (ListNode p = headA; p != null; p = p.next) ++s1;
            for (ListNode p = headB; p != null; p = p.next) ++s2;
            ListNode p = headA, q = headB;
            while (s1 < s2) {
                q = q.next;
                --s2;
            }
            while (s1 > s2) {
                p = p.next;
                --s1;
            }
            while (p != null && q != null) {
                if (p == q)
                    return p;
                p = p.next; q = q.next;
            }
            return null;
        }
    }
//    走过彼此的路
//    除了计算链表长度外，我们还可以利用 两链表长度和相等 的性质来使得两个遍历指针同步
//
//    具体做法是：先遍历其中一个链表，当到底末端后跳到另一链表，最后
//
//    若两链表没有公共结点，那么两个链表指针都会走过 s_1 + s_2s
//1
//        ​
//        +s
//2
//        ​
//    个结点，同时到达两链表末尾
//    若有公共结点，由于最后会同时走到两链表终点，所以倒退回去，两个指针一定会在第一个公共结点处相遇
//    当然，若两链表等长，那确实不会跳到另一链表，不过链表等长本身指针就是同步的，同样也能找到公共结点
//    走过彼此的路，两指针终会相遇❤️❤️❤️



    public class Solution4 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA, q = headB;
            while (p != q) {
                p = p == null ? headB : p.next;
                q = q == null ? headA : q.next;
            }
            return p;
        }
    }

}
