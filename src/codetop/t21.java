package codetop;

public class t21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (l1 != null && l2 != null ){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null){
            curr.next = l1;
        }

        if (l2 != null){
            curr.next = l2;
        }

        return head.next;

    }

    //递归的方法
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists_1(l1.next , l2);
            return l1;
        }else {
            l2.next = mergeTwoLists_1(l2.next , l1);
            return l2;
        }

    }
}



