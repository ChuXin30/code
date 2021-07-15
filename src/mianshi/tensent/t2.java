package mianshi.tensent;

public class t2 {
    Node merge(Node t1 , Node t2){
        Node root = new Node();
        Node ret = root;
        while (t1 != null && t2 != null){
            if(t1.val < t2.val){
                root.next = t1;
                t1 = t1.next;
            }else {
                root.next = t2;
                t2 = t2.next;
            }
            root = root.next;
        }
        if( t1 != null){
            root.next = t1;
        }else{
            root.next = t2;
        }
        return ret.next;
    }

    Node megers(Node[] nodes){
        Node ret = new Node();
        for (int i = 0 ; i < nodes.length ; i++ ){
            ret = merge(ret , nodes[i]);
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
