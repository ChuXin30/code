package codetop;

import java.util.HashMap;
import java.util.LinkedList;

public class t146 {
}

class Node{
    int key;
    int val;
    public Node(int key , int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int size = 0;
    HashMap<Integer , Node> hashMap ;
    LinkedList<Node> linkedList ;

    public LRUCache(int capacity) {
        size = capacity;
        hashMap = new HashMap<>();
        linkedList = new LinkedList<>();
    }

    public int get(int key) {
        if(!hashMap.containsKey(key))return -1;
        put(key , hashMap.get(key).val);
        return hashMap.get(key).val;
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if(hashMap.containsKey(key)){
            linkedList.remove(hashMap.get(key));
            linkedList.addFirst(x);
            hashMap.put(key,x);
        }else {
            if( linkedList.size() !=  size){
                linkedList.addFirst(x);
                hashMap.put(key,x);
            }else {
                Node rem = linkedList.getLast();
                linkedList.removeLast();
                hashMap.remove(rem.key);
                linkedList.addFirst(x);
                hashMap.put(key,x);
            }
        }
    }
}