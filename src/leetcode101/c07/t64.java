package leetcode101.c07;

//64. 最小路径和
//        给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//        说明：每次只能向下或者向右移动一步。
//
//
//
//        示例 1：
//
//
//        输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//        输出：7
//        解释：因为路径 1→3→1→1→1 的总和最小。
//        示例 2：
//
//        输入：grid = [[1,2,3],[4,5,6]]
//        输出：12

/*
一般看到从某一个点到另一个点的题会先想到用dfs或者bfs来做
但是这题限制了只能向下或者向右
所以也可以使用dp来做，
每次到了新的节点，我比较dp[i-1][j] 和dp[i][j-1]的最小值，加上当前节点
就是从0，0出发，到第i,j坐标的最短路径
然后返回dp[m][n] 即可
 */
public class t64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int i = 1 ; i < n ; i++ ){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for(int i = 1 ; i < m ; i++ ){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1 ; i < m ; i++){
            for (int j = 1 ; j < n ; j++ ){
                dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}
