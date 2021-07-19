package codetop;

public class t64 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0 ; i < n ; i++ ){
            for (int j = 0 ; j < i ; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0 ; i < n ; i++ ){
            for (int j = 0 ; j < i ; j++){
                if(i >= 1 && j >= 1) dp[i][j] = Math.min( dp[i-1][j] , dp[i][j-1] ) + grid[i][j];
                else if(i >= 1) dp[i][j] = dp[i-1][j] + grid[i][j];
                else if(j >= 1) dp[i][j] = dp[i][j-1] + grid[i][j];
                else dp[i][j] = grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
