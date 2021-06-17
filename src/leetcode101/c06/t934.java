package leetcode101.c06;

import java.util.Arrays;
import java.util.LinkedList;

//934. 最短的桥
//        在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
//
//        现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
//
//        返回必须翻转的 0 的最小数目。（可以保证答案至少是 1 。）
//
//
//
//        示例 1：
//
//        输入：A = [[0,1],[1,0]]
//        输出：1
//        示例 2：
//
//        输入：A = [[0,1,0],[0,0,0],[0,0,1]]
//        输出：2
//        示例 3：
//
//        输入：A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//        输出：1
public class t934 {
    LinkedList<int[]> queue = new LinkedList<int[]>();

    void dfs(int[][] grid , int x , int y ){
        int[][] dir = new int[][]{{1,0} , {-1, 0} , {0 , -1}, {0 ,1}};
        grid[x][y] = 2;

        for(int i = 0 ; i < 4 ; i++ ){
            int new_x = x + dir[i][0];
            int new_y = y + dir[i][1];
            if(new_x >= 0 && new_x < grid.length && new_y >= 0 && new_y < grid[0].length && grid[new_x][new_y] == 1 ){
                dfs(grid , new_x , new_y );
            }else {
                queue.offer(new int[]{new_x , new_y});
            }
        }
    }


    public int bfs(int[][] grid){
        int ret = 1;
        int[][] dir = new int[][]{{1,0} , {-1, 0} , {0 , -1}, {0 ,1}};

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int l = 0 ; l < size ; l++){
                int[] q = queue.poll();
                for(int k = 0 ; k < 4 ; k++ ){
                    int new_x = q[0] + dir[k][0];
                    int new_y = q[1] + dir[k][1];
                    if(new_x >= 0 && new_x < grid.length && new_y >= 0 && new_y < grid[0].length ){
                        if (grid[new_x][new_y] == 2)continue;
                        if (grid[new_x][new_y] == 1)return ret;
                        queue.offer(new int[]{new_x , new_y});
                        grid[new_x][new_y] = 2;
                    }
                }
            }
            ret++;
        }
        return ret;
    }

    public int shortestBridge(int[][] grid) {
        boolean flipped = false;
        for(int i = 0 ; i < grid.length ; i++){
            if (flipped) break;
            for (int j = 0 ; j < grid[0].length ; j++ ){
                if(grid[i][j] ==1 ){
                    dfs(grid , i , j );
                    flipped = true;
                    break;
                }
            }
        }

        // for (int i=0;i<grid.length;i++)
        //     System.out.println ( Arrays.toString (grid[i]));

        return bfs(grid );
    }
}
