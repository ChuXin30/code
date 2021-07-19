package test;

import java.util.*;

public class t2 {
    public static int[] GetEndPoint(String order) {
        // write code here
//        HashMap<Character , Integer> hashMap = new HashMap<>();
//        hashMap.put('W',1);
//        hashMap.put('S',-1);
//        hashMap.put('A',-1);
//        hashMap.put('D',1);
        int n = order.length();
        Deque<Long> stack = new LinkedList<>();
        int x = 0;
        int y = 0;
//        for (int i = 0 ; i < n ; i++ ){
//            char c = order.charAt(i);
//            if(c >= '0' && c <= '9' ){
//                stack.push((long)(c - '0'));
//            }else {
//                long num = 0;
//                if(stack.isEmpty()){
//                    num = 1;
//                }else {
//                    int size = 0;
//                    while (!stack.isEmpty()){
//                        num += Math.pow(10, size)*stack.pop();
//                        size++;
//                    }
//                }
//                if(c == 'W' ){
//                    y += num;
//                }else if(c == 'S' ){
//                    y -= num;
//                }else if(c == 'D'){
//                    x += num;
//                }else if(c == 'A' ){
//                    x -= num;
//                }
//            }
//        }
        int start = 0;
        int end = 0;


        return new int[]{(int)x, (int)y};
    }

    public static void main(String[] args) {
        for (int var : GetEndPoint("WAWAWAWA2DSDWASD")){
            System.out.print(var +" ");
        }
        System.out.println();
    }
}
