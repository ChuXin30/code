package leetcode101.c09;

import java.util.HashSet;

//202. 快乐数
//        编写一个算法来判断一个数 n 是不是快乐数。
//
//        「快乐数」定义为：
//
//        对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//        然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//        如果 可以变为  1，那么这个数就是快乐数。
//        如果 n 是快乐数就返回 true ；不是，则返回 false 。

public class t202 {
    public boolean isHappy(int n) {
        HashSet<Integer> hs =  new HashSet<Integer>();
        hs.add(n);
        while(n != 1){
            int happy_num = 0;
            while( n > 0){
                int a = n%10;
                n = n/10;
                happy_num += Math.pow(a,2);
            }
            n = happy_num;
            // System.out.println(n);
            if(hs.contains(happy_num)){
                return false;
            }else{
                hs.add(happy_num);
            }
        }
        return true;
    }

}
