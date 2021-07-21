package mianshi.baidu;

class Node {
    int val;
    mianshi.baidu.Node next;
    public Node(int val){
        this.val = val;
    }
}

public class t1_1 {
    static Node f(Node head){
        Node p = null;
        Node q = head;
        while (q != null){
            Node next_q = q.next;
            q.next = p;
            p = q;
            q = next_q;

        }
        return p;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node p = head;
        p.next = new Node(2);
        p = p.next;
        p.next = new Node(3);
        p = p.next;
        p.next = new Node(4);
        head = f(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
