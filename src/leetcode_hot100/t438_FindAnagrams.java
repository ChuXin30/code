package leetcode_hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//438. 找到字符串中所有字母异位词
//        给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
//        异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
//
//
//
//        示例 1:
//
//        输入: s = "cbaebabacd", p = "abc"
//        输出: [0,6]
//        解释:
//        起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//        起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。


public class t438_FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(hashMap.containsKey(c)){
                hashMap.put(c,hashMap.get(c)+1);
            }else {
                hashMap.put(c , 1);
            }
        }
        List<Integer> ret = new ArrayList<>();
        int left = 0, right = 0;
        int count = p.length();
        while (left < s.length()&& left <= right){

            while (  right < s.length()  ){
                char c = s.charAt(right);
                if(hashMap.containsKey(c) ){
                    hashMap.put(c , hashMap.get(c)-1);
                    if(hashMap.get(c) == 0){
                        count--;
                    }else {
                        count++;
                    }
                }
                if(count == 0 ){
                    ret.add(left);
                }
                right++;
                if((right - left) >= p.length()){
                    break;
                }
            }
            char left_c = s.charAt(left);
            if(hashMap.containsKey(left_c) ){
                hashMap.put(left_c, hashMap.get(left_c)+1);
                if(hashMap.get(left_c) == 0){
                    count--;
                }else {
                    count++;
                }
            }
            left++;
        }
        return ret;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        int [] s1  = new int[26];
        int [] p1 = new int[26];
        for(int i = 0; i < p.length(); i++){
            p1[p.charAt(i) - 'a']++;
        }
        List<Integer>res = new ArrayList<>();
        for(int l = 0, r = 0; r < s.length(); r++){
            s1[s.charAt(r) - 'a']++;
            if(r - l + 1 > p.length())s1[s.charAt(l++) - 'a']--;
            if(r - l + 1 == p.length() ){
                if(isSame(s1, p1)){
                    res.add(l);
                }
            }
        }
        return res;

    }
    boolean isSame (int[] a, int [] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i])return false;
        }
        return true;
    }

    public static void main(String[] args) {
        t438_FindAnagrams t =  new t438_FindAnagrams();
        t.findAnagrams("baa" , "aa");
    }
}
