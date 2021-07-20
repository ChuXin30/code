package acm.ali;

//1/10
//        [编程题]完美对
//        时间限制：C/C++ 5秒，其他语言10秒
//
//        空间限制：C/C++ 256M，其他语言512M
//
//        有个物品，每个物品有个属性，第件物品的第个属性用一个正整数表示记为，两个不同的物品被称为是完美对的当且仅当，求完美对的个数。
//
//        输入描述:
//        第一行两个数字。
//
//        接下来行，第行个数字表示。
//
//
//
//        输出描述:
//        一行一个数字表示答案
//
//        输入例子1:
//        5 3
//        2 11 21
//        19 10 1
//        20 11 1
//        6 15 24
//        18 27 36
//
//        输出例子1:
//        3

import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] nums = new int[n][m];
            for (int i = 0 ; i < n ; i++ ){
                for (int j = 0 ; j < m ; j++ ){
                    nums[i][j] = scanner.nextInt();
                }
            }
            int ret = 0;
            for (int i = 0 ; i < n-1 ; i ++){
                for (int j = i+1 ; j < n ; j++ ){
                    for(int l = 1 ; l < m ; l ++){
                        if( (nums[i][l] + nums[j][l]) != (nums[i][l-1] + nums[j][l-1]) ){
                            break;
                        }else if(l == m-1 && (nums[i][l] + nums[j][l]) == (nums[i][l-1] + nums[j][l-1]) ){
                            ret++;
                        }
                    }
                }
            }
            System.out.println(ret);

        }
    }
}
