package leetcode101.c05;

//451. 根据字符出现频率排序
//        给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
//
//        示例 1:
//
//        输入:
//        "tree"
//
//        输出:
//        "eert"
//
//        解释:
//        'e'出现两次，'r'和't'都只出现一次。
//        因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
//        示例 2:
//
//        输入:
//        "cccaaa"
//
//        输出:
//        "cccaaa"
//
//        解释:
//        'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//        注意"cacaca"是不正确的，因为相同的字母必须放在一起。
//        示例 3:
//
//        输入:
//        "Aabb"
//
//        输出:
//        "bbAa"
//
//        解释:
//        此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//        注意'A'和'a'被认为是两种不同的字符。

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class t451根据字符出现频率排序 {
    public class Node{
        Character c;
        Integer num;
        public Node(char c , int num){
            this.c = c;
            this.num = num;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character , Integer> hashMap = new HashMap<Character , Integer>();
        for(int i = 0 ; i < s.length() ; i++ ){
            hashMap.put(s.charAt(i) , hashMap.getOrDefault(s.charAt(i) , 0 ) +1);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if(a.num == b.num){
                    return (int)(a.c - b.c);
                }else  return  b.num - a.num;
            }
        });


        for (Character character : hashMap.keySet()){
            int num = hashMap.get(character);
            priorityQueue.offer(new Node(character , num));
        }

        String ret = "";
        while (!priorityQueue.isEmpty()){
            int num = priorityQueue.peek().num;
            char c =priorityQueue.peek().c;
            for(int i = 0 ; i < num ; i++){
                ret += c;
            }
        }
        return  ret;

    }
}
