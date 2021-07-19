package leetcode101.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class t179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for(int i = 0 ; i < n ; i++ ){
            strs[i] =   String.valueOf(nums[i]) ;
        }
        Arrays.sort(strs , new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o1+02).compareTo(o2+o1);
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0 ; i < n ; i++){
            stringBuffer.append(strs[i]);
        }
        return  stringBuffer.toString();

    }

    public static void main(String[] args) {

    }
}
