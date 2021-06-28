package leetcode101.c07;

//343. 整数拆分
//        给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
//        示例 1:
//
//        输入: 2
//        输出: 1
//        解释: 2 = 1 + 1, 1 × 1 = 1。
//        示例 2:
//
//        输入: 10
//        输出: 36
//        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//        说明: 你可以假设 n 不小于 2 且不大于 58。

/*
拆分问题
创建数组 \textit{dp}dp，其中 \textit{dp}[i]dp[i] 表示将正整数 ii 拆分成至少两个正整数的和之后，这些正整数的最大乘积。特别地，00 不是正整数，11 是最小的正整数，00 和 11 都不能拆分，因此 \textit{dp}[0]=\textit{dp}[1]=0dp[0]=dp[1]=0。

当 i \ge 2i≥2 时，假设对正整数 ii 拆分出的第一个正整数是 jj（1 \le j < i1≤j<i），则有以下两种方案：

将 ii 拆分成 jj 和 i-ji−j 的和，且 i-ji−j 不再拆分成多个正整数，此时的乘积是 j \times (i-j)j×(i−j)；

将 ii 拆分成 jj 和 i-ji−j 的和，且 i-ji−j 继续拆分成多个正整数，此时的乘积是 j \times \textit{dp}[i-j]j×dp[i−j]。

 */

public class t343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2 ; i <= n ; i++ ){
            int curMax = 0;
            for (int j = 1 ; j < i ; j++ ){
                curMax = Math.max(curMax , Math.max( j *(i-j) , j * dp[i-j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
