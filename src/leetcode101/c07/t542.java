package leetcode101.c07;

//542. 01 矩阵
//        给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
//
//        两个相邻元素间的距离为 1 。
//
//
//
//        示例 1：
//
//        输入：
//        [[0,0,0],
//        [0,1,0],
//        [0,0,0]]
//
//        输出：
//        [[0,0,0],
//        [0,1,0],
//        [0,0,0]]
//        示例 2：
//
//        输入：
//        [[0,0,0],
//        [0,1,0],
//        [1,1,1]]
//
//        输出：
//        [[0,0,0],
//        [0,1,0],
//        [1,2,1]]

/*
一般看到最近会想到bfs
但是bfs复杂度太高，
我们使用两次dp来做，分别从左上到右下
和从右下到左上，相当于完成在四个方向上的查找
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class t542 {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for (int j = 0; j < m ; j++)dp[i][j] = Integer.MAX_VALUE-1;
        }

        for(int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < m ; j++ ){
                if(mat[i][j] == 0)dp[i][j] = 0;
                else {
                    if(j > 0) dp[i][j] = Math.min(dp[i][j] , dp[i][j-1] + 1);
                    if(i > 0) dp[i][j] = Math.min(dp[i][j] , dp[i-1][j] + 1);
                }
            }
        }

        for(int i = n-1 ; i >= 0  ; i--){
            for (int j = m-1 ; j >= 0 ; j-- ){
                if(mat[i][j] != 0) {
                    if(j < m-1) dp[i][j] = Math.min(dp[i][j] , dp[i][j+1] + 1);
                    if(i < n-1) dp[i][j] = Math.min(dp[i][j] , dp[i+1][j] + 1);
                }
            }
        }
        return dp;
    }

}

//BFS算法
class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; ++d) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }

        return dist;
    }
}

