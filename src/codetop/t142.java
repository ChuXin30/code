package codetop;

import java.util.HashMap;
import java.util.HashSet;

public class t142 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null){
            if(hashSet.contains(head))return head;
            else hashSet.add(head);
            head = head.next;
        }
        return null;
    }
}
