package leetcode101.leetcode;

import java.util.Arrays;

public class t1269 {
    public int numWays(int steps, int arrLen) {
        if(arrLen == 1)return 1;
        int[] dp = new int[arrLen];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1 ; i < steps ; i++ ){
            int[] t = Arrays.copyOf(dp, arrLen) ;
            for(int j = 0 ; j < arrLen ; j++ ){
                if(j == 0 ){
                    dp[j] = (t[j]  + t[j+1])%( (int)Math.pow(10, 9) + 7 ) ;
                }else if( j == arrLen-1 ){
                    dp[j] = (int)(t[j] + t[j-1])%((int)Math.pow(10, 9) + 7);
                }else{
                    dp[j] = (int)(t[j] + t[j-1] + t[j+1])%( (int)Math.pow(10, 9) + 7 ) ;
                }
            }
        }
        return dp[0];
    }
}
