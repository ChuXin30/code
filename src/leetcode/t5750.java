package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class t5750 {
    public  static int max(int[][] logs){
        int ret = 0;
        int max = 0;
        for(int i = 1950 ; i <= 2050 ; i++ ){
            int t = 0;
            for(int j = 0 ; j < logs.length ; j++ ){
                if( i >= logs[j][0] && i < logs[j][1]  )t++;
            }
            if(t>max){
                max = t;
                ret = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
