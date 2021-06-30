package leetcode101.c11;

//48. 旋转图像
//        给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
//        你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//
//
//        示例 1：
//
//
//        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        输出：[[7,4,1],[8,5,2],[9,6,3]]
//        示例 2：
//
//
//        输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//        输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

public class t48 {
    //原地旋转
    public void rotate(int[][] matrix) {
        int temp = 0 , n = matrix.length -1 ;
        for (int i  = 0 ; i <= n/2 ; i++){
            for (int j = i ; j < n -i ; j++ ){
                temp = matrix[j][n-i];
                matrix[j][n-i] = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = temp;
            }
        }
    }
    //用翻转代替旋转 先水平翻转 后主对角线翻转
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
