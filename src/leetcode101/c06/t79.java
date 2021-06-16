package leetcode101.c06;
//79. 单词搜索
//        给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
//        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
//        示例 1：
//
//
//        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//        输出：true
//        示例 2：
//
//
//        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//        输出：true
//        示例 3：
//
//
//        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//        输出：false

//设计一个visited来标准一个地方是否已经访问过

public class t79 {
    int[][] dir = new int[][]{{1,0} , {-1, 0} , {0 , -1} , {0 ,1}};

    public boolean dfs( char[][] board , String word , int length , boolean[][] visited , int x , int y ){

        if( length == (word.length()) ){
            return true;
        }
        for (int i = 0 ; i < 4 ; i++ ){
            int new_x = x + dir[i][0];
            int new_y = y + dir[i][1];
            if( new_x >=0 && new_x < board.length && new_y >= 0 && new_y < board[0].length && !visited[new_x][new_y] && board[new_x][new_y] == word.charAt(length) ){
                // System.out.println(  board[new_x][new_y] + "\tlength="+length);

                visited[new_x][new_y] = true;
                if(dfs( board , word , length+1 , visited , new_x , new_y ))return true; //只要有一个为真就返回为真
                visited[new_x][new_y] = false;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++ ){
            for (int j = 0 ; j < m ; j++){
                if( board[i][j] == word.charAt(0)  ){
                    visited[i][j] = true;
                    if(dfs( board , word , 1 , visited , i , j ))return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
}
