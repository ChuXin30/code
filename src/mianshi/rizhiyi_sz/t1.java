package mianshi.rizhiyi_sz;

public class t1 {
}

class MyHashMap {
    private static class Node {
        String key;
        Integer value;
        Node next;
    }


    private final int SIZE = 2;
    private final Node[] nodes = new Node[SIZE];

    public MyHashMap() {
    }

    @Override
    public int hashCode() {

        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);
    }

    public void travel() {
        for (int i = 0; i < SIZE; i++) {
            Node node = nodes[i];
            if (node == null) {
                continue;
            }

            System.out.printf("Bucket #%d: %n", i);
            while (node != null) {
                System.out.printf("    node %d, %s, %s %n", i, node.key, node.value);
                node = node.next;
            }
        }
    }

    /* 需要支持key为null的场景 */
    public void put(String key, Integer value) {
        if(key == null){
            Node node_curr = nodes[0];
            while (node_curr.next != null){
                node_curr = node_curr.next;
            }
            node_curr.value = value;
            return;
        }

        int hashcode = (key).hashCode();
        int index = hashcode%2;
        Node node_curr = nodes[index];
        if(node_curr == null){
            nodes[index] = new Node();
            node_curr = nodes[index];
        }

        if(node_curr.next == null ){
            node_curr.key = key;
            node_curr.value = value;
            node_curr.next = new Node();
        }else {
            while (node_curr.next != null){
                if(node_curr.key == key){
                    node_curr.value = value;
                    break;
                }
                node_curr = node_curr.next;
            }
            node_curr.key = key;
            node_curr.value = value;
            node_curr.next = new Node();
        }
    }

    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();

        System.out.println("----------------------");
        hm.put("aba", 121);
        hm.put("abb", 122);
        hm.put("abc", 123);
        hm.put("abd", 124);
        hm.put("abe", 125);
        hm.put(null, 345);
        hm.travel();

        System.out.println("----------------------");
        hm.put("aba", 1210);
        hm.put("abb", 1220);
        hm.put("abc", 1230);
        hm.put("abd", 1240);
        hm.put("abe", null);
        hm.put(null, 3450);
        hm.travel();
    }
}