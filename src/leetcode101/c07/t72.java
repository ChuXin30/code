package leetcode101.c07;
//72. 编辑距离
//        给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
//        你可以对一个单词进行如下三种操作：
//
//        插入一个字符
//        删除一个字符
//        替换一个字符
//
//
//        示例 1：
//
//        输入：word1 = "horse", word2 = "ros"
//        输出：3
//        解释：
//        horse -> rorse (将 'h' 替换为 'r')
//        rorse -> rose (删除 'r')
//        rose -> ros (删除 'e')
//        示例 2：
//
//        输入：word1 = "intention", word2 = "execution"
//        输出：5
//        解释：
//        intention -> inention (删除 't')
//        inention -> enention (将 'i' 替换为 'e')
//        enention -> exention (将 'n' 替换为 'x')
//        exention -> exection (将 'n' 替换为 'c')
//        exection -> execution (插入 'u')

/*
类似于题目1143，我们使用一个二维数组dp[i][j]，表示将第一个字符串到位置i 为止，和第
二个字符串到位置j 为止，最多需要几步编辑。当第i 位和第j 位对应的字符相同时，dp[i][j] 等
于dp[i-1][j-1]；当二者对应的字符不同时，修改的消耗是dp[i-1][j-1]+1，插入i 位置/删除j 位置
的消耗是dp[i][j-1] + 1，插入j 位置/删除i 位置的消耗是dp[i-1][j] + 1。
 */

public class t72 {
    public int minDistance(String word1, String word2) {



        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        // 有一个字符串为空串
        if (n1 * n2 == 0) {
            return n1+n2;
        }
        for(int i = 0 ; i <= n1 ; i++ ){
            dp[i][0] = i;
        }
        for(int i = 0 ; i <= n2 ; i++ ){
            dp[0][i] = i;
        }

        for(int i = 1 ; i <= n1 ; i++ ){
            for (int j = 1 ; j <= n2 ; j++ ){
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                if( c1 == c2 ){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(  Math.min( dp[i][j-1] , dp[i-1][j] ) , dp[i-1][j-1] ) + 1;
                }
            }
        }

        return dp[n1][n2] ;
    }
}
