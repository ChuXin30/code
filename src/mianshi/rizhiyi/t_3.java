package mianshi.rizhiyi;

public class t_3 {

    static  int f(int n){
        int[][] dp = new int[2][n+1];
        //dp[1][n] 字符串第n位为1的可能的次数
        //dp[0][n] 代表了第n位为0的可能的次数

        dp[0][1] = 1; //第一位为0的次数为1
        dp[1][1] = 0; //第一位为1的次数为0

        for (int i = 2 ; i <= n ; i++ ){
            dp[0][i] = dp[1][i-1]; //第i为为0的次数 为第i-1位为1的次数
            dp[1][i] = dp[1][i-1] + dp[0][i-1]; // 第i位位1的次数 位第i-1位为0的次数 加 第i-1位为1的次数
        }

//        System.out.println(dp[0][19]);
        return dp[0][n];//返回第n位为0的次数
    }

    public static void main(String[] args) {
        System.out.println(f(19));// 一共 1597种
    }
}
