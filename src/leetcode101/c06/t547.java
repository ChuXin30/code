package leetcode101.c06;
//547. 省份数量
//        有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
//
//        省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
//
//        给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
//
//        返回矩阵中 省份 的数量。
//
//
//
//        示例 1：
//
//
//        输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//        输出：2
//        示例 2：
//
//
//        输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//        输出：3
public class t547 {
    int n ;
    public void dfs(int[][] isConnected , int row , boolean[] visited ){
        visited[row] = true;
        for(int i = 0 ; i < n  ; i++ ){
            if( !visited[i] && isConnected[row][i] == 1 ){
                dfs(isConnected ,  i , visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++ ){
            if( !visited[i] ){
                dfs( isConnected , i  , visited);
                count++;
            }
        }
        return count;
    }
}
