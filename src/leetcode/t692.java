package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class t692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String , Integer> hm = new HashMap<String,Integer>();
        int n = words.length;
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++ ){
            if(hm.containsKey(words[i])){
                hm.put(words[i], hm.get(words[i])+1 );
            }else {
                hm.put(words[i], 1 );
            }
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        return  arrayList;
    }
}
