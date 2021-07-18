package codetop;

public class t25 {
    private  static  ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null){
            for (int i = 0 ; i < k && end != null ; i++)end = end.next;
            if(end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;

            pre = start;
            end = pre;
        }
        return dummy.next;


//        ListNode pre = null;
//        ListNode curr = head;
//
//
//        int length = 0;
//        while (curr != null){
//            curr = curr.next;
//            length++;
//        }
//
//        int i = 0;
//        int index = 0;
//        curr = head;
//        ListNode first = null;
//
//        while ( (index + k) < length ){
//            System.out.println( curr.val + " " + "i="+i + " index="+index);
//            if(curr != null && i < k ){
//                if(i == 0)first = curr;
//                ListNode next = curr.next;
//                curr.next = pre;
//                pre = curr;
//                curr = next;
//                i++;
//            }else{
//                i = 0;
//                first.next = curr;
//                pre = null;
////                head = first;
////                curr = curr.next;
//            }
//            index++;
//        }
//        return  head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        curr.next = new ListNode(2);
        curr = curr.next;
        curr.next = new ListNode(3);
        curr = curr.next;
        curr.next = new ListNode(4);
        curr = curr.next;
        curr.next = new ListNode(5);

        reverseKGroup(head , 2);
    }
}
