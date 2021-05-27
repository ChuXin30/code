package leetcode;

public class tes1 {
    public static   int findMaxLength(String s){
        int n = s.length();
        if(n <=0 )return 0;
        if(n == 1)return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i < n ; i++ ){
            if(s.charAt(i) == s.charAt(i-1)){
                dp[i] = dp[i-1]+1;
            }else{
                dp[i] = 1;
            }
            max = Math.max(dp[i] , max);
        }
//        for(int i = 0; i < n ; i++)System.out.print("i="+i+" "+dp[i]+" ");
        return max;
    }

    public static void main(String[] args) {
        System.out.println("max="+findMaxLength("ISDHFSHFDAAFA") );
//        System.out.println("max="+findMaxLength("SA") );

    }
}
