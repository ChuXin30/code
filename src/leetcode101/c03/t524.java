package leetcode101.c03;

//524. 通过删除字母匹配到字典里最长单词
//        给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
//
//        如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
//
//
//
//        示例 1：
//
//        输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//        输出："apple"
//        示例 2：
//
//        输入：s = "abpcplea", dictionary = ["a","b","c"]
//        输出："a"

import java.util.List;

public class t524 {

    public boolean match(String s1 , String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int p1 = 0;
        int p2 = 0;
        while (p1 < n1 && p2 < n2){
            if(s1.charAt(p1) == s2.charAt(p2)){
                p1++; p2++;
            }else{
                p1++;
            }
        }
        return p2 == n2;
    }

    public String findLongestWord(String s, List<String> dictionary) {

        String maxString = "";
        int n = dictionary.size();
        for(int i = 0 ; i < n ; i++  ){
            String s2 = dictionary.get(i);
            // System.out.println( "s2 "+s2+ " match="+match(s , s2));
            if(match(s , s2)){
                if( s2.length() > maxString.length()  || (s2.length() == maxString.length() && s2.compareTo(maxString ) < 0)  ){
                    maxString =s2;
                }
            }
        }

        return maxString;
    }
}
