package mianjin.meitaun;

import java.util.Scanner;

//动态规划求解，构建一个(n+1)*2的dp数组，dp[i][0]表示凑出i时没有使用大于等于d的数的方案数，dp[i][1]表示凑出 i 时用了大于等于d的数的方案数。在凑某个数i时，状态转移有如下情况：
//        (1) 如果此时要填的数 j<d：
//        因为凑成 i 没有使用大于等于 d 的数，那凑成 i-j 也没有使用大于等于 d 的数，dp[i][0]只会从dp[i-j][0]转移过来，dp[i][1]也只会从dp[i-j][1]转移过来。而这种填数游戏在 i-j 的填数方案已经确定的情况下，现在要填数 j 应该满足累加的原则，所以在遍历 j 时，j 每取一个值就把前面的方案数加一次，状态转移方程为：
//        dp[i][0] = dp[i][0] + ∑dp[i-j][0]
//        dp[i][1] = dp[i][1] + ∑dp[i-j][1]
//        (2) 如果此时要填的数 j>=d：因为现在要填的 j 已经满足大于等于 d 了，所以填数方案中至少得有一个数大于等于d的成就已经达成，凑成 i-j 有没有使用大于等于 d 的数已经不重要。此时只更新dp[i][1]，dp[i][1]可以从dp[i-j][0]和dp[i-j][1]两个状态转移过来，状态转移方程为：
//        dp[i][1] = dp[i][1] + ∑(dp[i-j][0]+dp[i-j][1])。

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int d = scanner.nextInt();
            long[][] dp = new long[n + 1][2];
            dp[0][0] = 1;
            for(int i = 1; i <= n; i++){
                // 题目要求填的正整数范围是从1~k，但是也不能超过目标值i
                for(int j = 1; j <= Math.min(k, i); j++){
                    if(j < d){
                        dp[i][0] = (dp[i][0] + dp[i - j][0]) % 998244353;
                        dp[i][1] = (dp[i][1] + dp[i - j][1]) % 998244353;
                    }else
                        dp[i][1] = (dp[i][1] + dp[i - j][0] + dp[i - j][1]) % 998244353;
                }
            }
            // 输出凑出了n并且使用了大于等于d的数的方案数
            System.out.println(dp[n][1]);
        }
    }
}
