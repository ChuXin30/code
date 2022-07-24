package mianshi.tensent_bishi;


import java.util.LinkedList;

public class t1 {


    static public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
          this.val = val;
        }
      }


    static public ListNode solve (ListNode[] a) {
        // write code here
        int size = a.length;
        if(size == 0)return null;
        if(size == 1 )return a[0];

        ListNode head = new ListNode(0);
        ListNode p = head;

        int count = 0;
        while (count < size){
            count = 0;
            for (int i = 0; i < size; i++) {
                if(a[i] != null){
                    p.next = a[i];
                    a[i] = a[i].next;
                    p = p.next;
                }else {
                    count ++;
                }
            }
        }
        return head.next;

    }

    public static void main(String[] args) {
        ListNode[] a = new ListNode[3];
        ListNode head1 = new ListNode(1);
        ListNode p1 = head1;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(3);

        ListNode head2 = new ListNode(4);
        ListNode p2 = head2;
        p2.next = new ListNode(5);
//        p2 = p2.next;
//        p2.next = new ListNode(5);

        ListNode head3 = new ListNode(7);
        ListNode p3 = head3;
        p3.next = new ListNode(8);
        p3 = p3.next;
        p3.next = new ListNode(9);
        p3 = p3.next;
        p3.next = new ListNode(10);
        p3 = p3.next;
        p3.next = new ListNode(11);
        p3 = p3.next;
        p3.next = new ListNode(12);

        a[0] = head1;
        a[1] = head2;
        a[2] = head3;

        ListNode ret = solve(a);

        while (ret != null){
            System.out.println(ret.val);
            ret = ret.next;
        }

    }

}
