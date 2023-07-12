package src.leetcode101.c01;

//763. 划分字母区间
//        字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//
//
//
//        示例：
//
//        输入：S = "ababcbacadefegdehijhklij"
//        输出：[9,7,8]
//        解释：
//        划分结果为 "ababcbaca", "defegde", "hijhklij"。
//        每个字母最多出现在一个片段中。
//        像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class t763 {
    public List<Integer> partitionLabels(String s) {
        HashMap< Character , int[]> hashMap = new HashMap< Character, int[]>();
        int length = s.length();
        for (int i = 0 ; i < length ; i++){
            char c = s.charAt(i);
            if(!hashMap.containsKey(c)){
                hashMap.put(c , new int[]{i , i});
            }else {
                int[] pre = hashMap.get(c);
                pre[1] = i;
                hashMap.put(c , pre );
            }
        }

        List<Integer> ret = new ArrayList<Integer>();
        int pre = -1;
        for(int i = 0 ; i < length ; i++ ){
            char c = s.charAt(i);
            int tail = hashMap.get(c)[1];
            int head = hashMap.get(c)[0];
            if(  head > pre  ){
                ret.add(tail);
                pre = tail;
            }else if( head <= pre && tail > pre ){
                ret.set(ret.size()-1 , tail);
                pre = tail;
            }
        }
        List<Integer> ret1 = new ArrayList<Integer>();

        ret1.add(ret.get(0)+1);
        for(int i = 1 ; i < ret.size() ; i++){
            ret1.add( ret.get(i)-ret.get(i-1));
        }
        return  ret1;
    }
}
