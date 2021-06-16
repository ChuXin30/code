package leetcode101.c06;

import java.util.ArrayList;
import java.util.List;

//417. 太平洋大西洋水流问题
//        给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
//
//        规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
//
//        请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
//
//
//
//        提示：
//
//        输出坐标的顺序不重要
//        m 和 n 都小于150
//
//
//        示例：
//
//
//
//        给定下面的 5x5 矩阵:
//
//        太平洋 ~   ~   ~   ~   ~
//        ~  1   2   2   3  (5) *
//        ~  3   2   3  (4) (4) *
//        ~  2   4  (5)  3   1  *
//        ~ (6) (7)  1   4   5  *
//        ~ (5)  1   1   2   4  *
//        *   *   *   *   * 大西洋
//
//        返回:
//
//        [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
public class t417 {
    int n;
    int m;
    public void dfs(int[][] heights , int i , int j , boolean visied[][]  ){
        visied[i][j] = true;
        int[][] dir = new int[][]{  {1,0} , {-1,0} , {0,1} , {0,-1} };
        for(int k = 0 ; k < 4 ; k++){
            int row = i + dir[k][0];
            int col = j + dir[k][1];
            if(  row >= 0 && row < n && col >= 0 && col < m &&  !visied[row][col] && heights[i][j] <= heights[row][col] ){
                visied[row][col] = true;
                dfs(heights , row , col , visied );
            }
        }
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        List<List<Integer>> ret = new ArrayList<>();


        boolean[][] visited_p = new boolean[n][m];
        boolean[][] visited_q = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            dfs(heights , i , 0 , visited_p);
            dfs(heights , i , m-1 , visited_q);
        }

        for (int i = 0 ; i < m ; i++){
            dfs(heights , 0 , i , visited_p );
            dfs(heights , n-1 , i , visited_q);
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if( visited_p[i][j] && visited_q[i][j] ){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);l.add(j);
                    ret.add(l);
                }
            }
        }
        return ret;
    }

}
