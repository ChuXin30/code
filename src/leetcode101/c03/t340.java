package leetcode101.c03;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

//    340. 至多包含 K 个不同字符的最长子串
//            给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
//
//            示例 1:
//
//            输入: s = "eceba", k = 2
//            输出: 3
//            解释: 则 T 为 "ece"，所以长度为 3。
//            示例 2:
//
//            输入: s = "aa", k = 1
//            输出: 2
//            解释: 则 T 为 "aa"，所以长度为 2。
public class t340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0;
        int r = 0;
        int n = s.length();
        HashMap<Character , Integer> hashMap = new HashMap<Character , Integer>();
        int ret = 0;


        while (r < n ){
            hashMap.put(s.charAt(r) , r);
            r++;
            if(hashMap.size() >= k+1){
                int index = Collections.min(hashMap.values());
                hashMap.remove(s.charAt(index));
                l = index +1;
            }
            ret = Math.max(ret, r-l);
        }
        return  ret;
    }

}
