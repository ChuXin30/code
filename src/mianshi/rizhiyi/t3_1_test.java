package mianshi.rizhiyi;

public class t3_1_test {
    static  int f(int n){
        int[][] dp = new int[2][n+1];
        //dp[1][n] 字符串第n位为1的可能的次数
        //dp[0][n] 代表了第n位为0的可能的次数

        dp[0][1] = 1; //第一位为0的次数为1
        dp[1][1] = 0; //第一位为1的次数为0

        for (int i = 2 ; i <= n ; i++ ){
            dp[1][i] = dp[0][i-2] + dp[0][i-1]  ; // 第i位位1的次数 位第i-2位为0的次数 加 第i-1位为1的次数
            dp[0][i] =  dp[1][i-1]; //第i为为0的次数 为第i-1位为1的次数
        }
//        for (int i = 0 ; i <= n ; i++){
//            System.out.print(dp[0][i] + "  ");
//        }
//        System.out.println();
//        for (int i = 0 ; i <= n ; i++){
//            System.out.print(dp[1][i] + "  ");
//        }
//        System.out.println();
//        System.out.println(dp[0][19]);
        return dp[0][n];//返回第n位为0的次数
    }

    public static void main(String[] args) {
        System.out.println(f(9));// 一共 65
//        System.out.println(f(3));
//        System.out.println(f(4));
//        System.out.println(f(5));
//        System.out.println(f(6));
//        System.out.println(f(7));
//        System.out.println(f(8));

    }
}
