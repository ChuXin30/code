package codetop;

import java.util.HashMap;
import java.util.HashSet;

public class t3 {
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int n = s.length();
        if(n<=1)return n;
        HashMap<Character , Integer> hashMap = new HashMap<>();
        int max = 0;

        for(end = 0 ; end < n ; end++ ){
            char c =  s.charAt(end);
            if(hashMap.containsKey(c)){
                start = Math.max(hashMap.get(c)+1 , start) ;
            }

            hashMap.put(c , end);
            max = Math.max((end-start) +1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
