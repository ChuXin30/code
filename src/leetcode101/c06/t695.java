package leetcode101.c06;

//695. 岛屿的最大面积
//        给定一个包含了一些 0 和 1 的非空二维数组 grid 。
//
//        一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
//
//        找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
//
//
//
//        示例 1:
//
//        [[0,0,1,0,0,0,0,1,0,0,0,0,0],
//        [0,0,0,0,0,0,0,1,1,1,0,0,0],
//        [0,1,1,0,1,0,0,0,0,0,0,0,0],
//        [0,1,0,0,1,1,0,0,1,0,1,0,0],
//        [0,1,0,0,1,1,0,0,1,1,1,0,0],
//        [0,0,0,0,0,0,0,0,0,0,1,0,0],
//        [0,0,0,0,0,0,0,1,1,1,0,0,0],
//        [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//        对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
//
//        示例 2:
//
//        [[0,0,0,0,0,0,0,0]]
//        对于上面这个给定的矩阵, 返回 0。

public class t695 {
    int n ;
    int m;
    public int dfs(int[][] grid , int row , int col ){
        if(grid[row][col] == 0)return 0;
        int[][] dir = new int[][]{ {1,0} , {0 ,1} , {-1 , 0} , {0 , -1} };
        int area = 1;
        grid[row][col] = 0; //防止重新访问
        for(int i = 0 ; i < 4  ; i++ ){
            int h = row + dir[i][0];
            int w = col + dir[i][1];
            if(h>=0 && h < n && w >=0 && w < m ){
                area += dfs(grid , h , w );
            }
        }
        return  area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ret = -1;
        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    ret = Math.max(dfs( grid , i , j ) , ret);
                }
            }
        }
        return ret;
    }
}
