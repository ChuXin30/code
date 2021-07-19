package test;

public class t1 {
    public class Solution {
        /**
         * Note: 类名、方法名、参数名已经指定，请勿修改
         *
         *
         * find min override sub string
         * @param source string字符串
         * @param target string字符串
         * @return string字符串
         */
        public String findMinOverrideSubString(String source, String target) {
            if (source == null || source.length() == 0 || target == null || target.length() == 0){
                return "";
            }
            int[] need = new int[128];
            for (int i = 0; i < target.length(); i++) {
                need[target.charAt(i)]++;
            }
            int l = 0, r = 0, size = Integer.MAX_VALUE, count = target.length(), start = 0;
            while (r < source.length()) {
                char c = source.charAt(r);
                if (need[c] > 0) {
                    count--;
                }
                need[c]--;
                if (count == 0) {
                    while (l < r && need[source.charAt(l)] < 0) {
                        need[source.charAt(l)]++;
                        l++;
                    }
                    if (r - l + 1 < size) {
                        size = r - l + 1;
                        start = l;
                    }
                    need[source.charAt(l)]++;
                    l++;
                    count++;
                }
                r++;
            }
            return size == Integer.MAX_VALUE ? "" : source.substring(start, start + size);
        }
    }
}


//    public String minWindow(String source, String target) {
//        if(source.length() < target.length())return "";
//
//        int[] hm = new int[52];
//        for(int j = 0 ; j < target.length() ; j++){
//            char c2 = target.charAt(j);
//            if( c2>='a' && c2 <= 'z' ){
//                hm[c2-'a']++;
//            }else{
//                hm[c2-'A'+26]++;
//            }
//        }
//        String rets = source;
//        boolean flag = false;
//        for(int i = 0 ; i < source.length() ; i++){
//            char c = source.charAt(i);
//            int index;
//            if(c >= 'a' && c <= 'z')index = c -'a';
//            else index = c-'A'+26;
//            if(hm[index] == 0)continue;
//            if(target.length() > (source.length() - i))break;
//
//            int[] hm1 = new int[52];
//            for(int j = 0 ; j < target.length() ; j++){
//                char c2 = target.charAt(j);
//                if( c2>='a' && c2 <= 'z' ){
//                    hm1[c2-'a']++;
//                }else{
//                    hm1[c2-'A'+26]++;
//                }
//            }
//
//            int matchLength = 0;
//            int n = target.length();
//            int start = i;
//
//            for(int j = i ; j < source.length() ; j++){
//                char c1 = source.charAt(j);
//                int index1;
//                if(c1 >= 'a' && c1 <= 'z')index1 = c1-'a';
//                else index1 = c1-'A'+26;
//                if( hm1[index1] >= 1){
//                    matchLength++;
//                    hm1[index1]--;
//                }
//                if(matchLength == n){
//                    flag = true;
//                    if( (j - i) < rets.length() ){
//                        rets = source.substring(i , j+1);
//                    }
//                    break;
//                }
//            }
//        }
//        if(flag)return rets;
//        else return "";
//    }