package leetcode101.c06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//51. N 皇后
//        n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//        给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//        每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
//        示例 1：
//
//
//        输入：n = 4
//        输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//        解释：如上图所示，4 皇后问题存在两个不同的解法。
//        示例 2：
//
//        输入：n = 1
//        输出：[["Q"]]
public class t51 {
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public void dfs(List<List<String>> solutions , int [] queens , int n , int row , HashSet<Integer> columns ,HashSet<Integer> diagonals1 ,HashSet<Integer> diagonals2){
        if(row == n){
            List<String> board = generateBoard(queens , n);
            solutions.add(board);
        }else {
            for(int i = 0 ; i < n ; i++ ){// i 代表列
                if(columns.contains(i))continue;
                int d1 = row - i; // 代表行减 列
                if(diagonals1.contains(d1))continue;
                int d2 = row + i;
                if(diagonals2.contains(d2))continue;
                queens[row] = i;
                columns.add(i);
                diagonals1.add(d1);
                diagonals2.add(d2);
                dfs(solutions , queens , n , row+1 , columns , diagonals1 , diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(d1);
                diagonals2.remove(d2);
            }
        }
    }


    public List<List<String>> solveNQueens(int n) {
        //1. 使用一个int[][] 来保存第i,j 个位置 的左斜 是否有一个皇后
        //2. 使用一个int[][] 来保存第i,j 个位置 的右斜 是否有一个皇后
        //3. 使用一个int[][] 来保存第i,j 个位置 的列 是否有一个皇后
        //4. 使用一个int[][] 来保存第i,j 个位置 的行 是否有一个皇后

        List<List<String>> solutions = new ArrayList<List<String>>();
        int [] queens = new int[n];
        Arrays.fill(queens, -1);
        HashSet<Integer> columns = new HashSet<Integer>();
        HashSet<Integer> diagonals1 = new HashSet<Integer>();
        HashSet<Integer> diagonals2 = new HashSet<Integer>();
        dfs(solutions , queens , n , 0 , columns , diagonals1 , diagonals2);
        return solutions;
    }
}
