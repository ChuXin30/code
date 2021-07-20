package acm.ali;

import java.util.ArrayList;
import java.util.Scanner;

//[编程题]选择物品
//        时间限制：C/C++ 1秒，其他语言2秒
//
//        空间限制：C/C++ 256M，其他语言512M
//
//        有个物品可供选择，必须选择其中个物品，请按字典序顺序输出所有选取方案的物品编号
//
//        与与等被认为是同一种方案，输出字典序最小的即可
//
//
//        输入描述:
//        对于每一组测试数据， 每行输入个数和。
//
//
//
//
//        输出描述:
//        对于每组输入样例，按字典序输出所有方案选择物品的编号，每种方案占一行
//
//        输入例子1:
//        4 1
//
//        输出例子1:
//        1
//        2
//        3
//        4
//
//        输入例子2:
//        5 2
//
//        输出例子2:
//        1 2
//        1 3
//        1 4
//        1 5
//        2 3
//        2 4
//        2 5
//        3 4
//        3 5
//        4 5


public class t2 {
    static void dfs(boolean[] visitd, ArrayList<Integer> arrayList, int num, int length){
        if(arrayList.size() == length){
            int n = arrayList.size();
            for (int i = 0 ; i < n-1 ; i++){
                System.out.print(arrayList.get(i) + " ");
            }
            System.out.println(arrayList.get(n-1));
        }
        for (int i = 0 ; i < num ; i++  ){
            if(!visitd[i] ){
                if(arrayList.size() < 1 || arrayList.size() >= 1 && (i+1) > arrayList.get(arrayList.size()-1)){
                    arrayList.add(i+1);
                    visitd[i] = true;
                    dfs(visitd , arrayList , num , length);
                    arrayList.remove(arrayList.size()-1);
                    visitd[i] = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            boolean[] visitd = new boolean[n];
            ArrayList<Integer> arrayList = new ArrayList<>();

            dfs( visitd , arrayList, n ,  m);

        }
    }
}
