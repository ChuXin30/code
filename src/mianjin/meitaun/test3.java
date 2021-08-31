package mianjin.meitaun;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] matrix = new int[n][m];
            for(int i = 0 ; i < n ; i++ ){
                for (int j = 0 ; j < m ; j++ ){
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int hight = n;
            int width = m;



            while (hight >= 1){
                boolean flag = true;
                for (int i = 0 ; i < hight/2 ; i++ ){
                    for (int j = 0 ; j < width ; j++ ){
                        if(matrix[i][j] != matrix[hight - i -1][j])flag = false;
                    }
                }
                if(!flag){
                    break;
                }
                hight = hight/2;
            }

            for (int i = 0 ; i < hight ; i++ ){
                for (int j = 0 ; j < width -1 ; j++ ){
                    System.out.print( matrix[i][j] + " " );
                }
                System.out.println(matrix[i][width-1]);
            }

        }
    }
}
