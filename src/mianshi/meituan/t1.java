package mianshi.meituan;

import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            long[][] dp = new long[4][n+1];
            if(n == 1) System.out.println(2);
            else if(n == 2) System.out.println(4);
            else {
                //aa ab ba bb
                dp[0][2] = 1;
                dp[1][2] = 1;
                dp[2][2] = 1;
                dp[3][2] = 1;



                for (int i  = 3 ; i <= n ; i++ ){
                    dp[0][i] = (dp[0][i-1] + dp[2][i-1])%998244353;
                    dp[1][i] = dp[0][i-1]%998244353;
                    dp[2][i] = dp[3][i-1]%998244353;
                    dp[3][i] = (dp[3][i-1] + dp[1][i-1])%998244353;

//                    dp[0][i] = (dp[0][i-1] + dp[2][i-1]);
//                    dp[1][i] = dp[0][i-1];
//                    dp[2][i] = dp[3][i-1];
//                    dp[3][i] = (dp[3][i-1] + dp[1][i-1]);

                }
                System.out.println( (dp[0][n] + dp[1][n] + dp[2][n] + dp[3][n])%998244353  );
            }
            /*
            dp[0][1] 标识前一位为a的出现次数 dp[1][1] 标识前1位为b次数
            1 a b
            2 ab aa bb ba
            3 abb
            aab aaa
            bba bbb
            baa
            4 abba abbb
             aabb
             aaaa aaab
             bbaa
             bbba bbbb
             baaa baab
            5 abbaa
            abbba abbbb
            aabba aabbb
            aaaaa aaaab
            aaabb
            bbaaa bbaab
            bbbaa
            bbbbb bbbba
            baaaa baaab
            baabb
            2 4 6 10 16
             */


        }
    }
}
