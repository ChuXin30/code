package leetcode101.c07;

//221. 最大正方形
//        在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
//
//
//        示例 1：
//
//
//        输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//        输出：4
//        示例 2：
//
//
//        输入：matrix = [["0","1"],["1","0"]]
//        输出：1

/*
dp[i][j] 表示满足题目条件的、以(i, j) 为右下角的正方形或者长方形的属性
我们假设dp[i][j] = k2，其充分条件为dp[i-1][j-1]、dp[i][j-1] 和dp[i-1][j] 的值必须
都不小于¹k 􀀀 1º2
 */

public class t221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(m*n == 0)return 0;
        int[][] dp = new int[n+1][m+1];
        int ret = 0;


        for(int i = 1 ; i <= n ; i++){
            for (int j = 1 ; j <= m ; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min( dp[i-1][j] , dp[i][j-1] )) + 1;
                }
                ret = Math.max(ret , dp[i][j]);
            }
        }
        return ret*ret;
    }

}
