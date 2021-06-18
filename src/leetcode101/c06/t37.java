package leetcode101.c06;

//37. 解数独
//        编写一个程序，通过填充空格来解决数独问题。
//
//        数独的解法需 遵循如下规则：
//
//        数字 1-9 在每一行只能出现一次。
//        数字 1-9 在每一列只能出现一次。
//        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//        数独部分空格内已填入了数字，空白格用 '.' 表示。
//
//
//
//        示例：
//
//
//        输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
//        输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
//        解释：输入的数独如上图所示，唯一有效的解决方案如下所示：


import java.util.HashSet;


//有问题
public class t37 {
    HashSet<Character>[] clo;
    HashSet<Character>[] row;
    HashSet<Character>[] mash;
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    boolean dfs(char[][] board , int x , int y ){
        if( y == 9 ){
            x += 1;
            y = 0;
            if(x == 9 )return true;
        }else{
            if( board[x][y] == '.' ){
                for(int i = 1 ; i < 10 ; i++ ){
                    char c = (char) ('0' + i);
                    int m = (x/3)*3 + (y/3);
                    if(  !row[x].contains(c) && !clo[y].contains(c) && !mash[m].contains(c) ){
                        row[x].add(c);
                        clo[y].add(c);
                        mash[m].add(c);
                        board[x][y] = c;

                        if(dfs(board , x , y+1))return true;

                        row[x].remove(c);
                        clo[y].remove(c);
                        mash[m].remove(c);
                        board[x][y] = '.';
                    }
                }
            }else{
                return dfs(board , x , y+1 );
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        int n = board.length;
        clo = new HashSet[9];
        row = new HashSet[9];
        mash = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<Character>();
            clo[i] = new HashSet<Character>();
            mash[i] = new HashSet<Character>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int m = (i / 3) * 3 + (j / 3);
                char c = board[i][j];
                if (c != '.') {
                    row[i].add(c);
                    clo[j].add(c);
                    mash[m].add(c);
                }
            }
        }

        dfs(board, 0, 0);
    }
}




//正确

class Solution {
    public void solveSudoku(char[][] board) {
        // 三个布尔数组 表明 行, 列, 还有 3*3 的方格的数字是否被使用过
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        // 初始化
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++) {
                int num = board[row][col] - '0';
                if(1 <= num && num <= 9){
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row/3][col/3][num] = true;
                }
            }
        }
        // 递归尝试填充数组
        recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, 0, 0);
    }

    private boolean recusiveSolveSudoku(char[][]board, boolean[][]rowUsed, boolean[][]colUsed, boolean[][][]boxUsed, int row, int col){
        // 边界校验, 如果已经填充完成, 返回true, 表示一切结束
        if(col == board[0].length){
            col = 0;
            row++;
            if(row == board.length){
                return true;
            }
        }
        // 是空则尝试填充, 否则跳过继续尝试填充下一个位置
        if(board[row][col] == '.') {
            // 尝试填充1~9
            for(int num = 1; num <= 9; num++){
                boolean canUsed = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row/3][col/3][num]);
                if(canUsed){
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row/3][col/3][num] = true;

                    board[row][col] = (char)('0' + num);
                    if(recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1)){
                        return true;
                    }
                    board[row][col] = '.';

                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    boxUsed[row/3][col/3][num] = false;
                }
            }
        } else {
            return recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1);
        }
        return false;
    }
}


