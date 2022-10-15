package acm.ali;

//1/10
//        [编程题]子集
//小强现在有个物品,每个物品有两种属性和.他想要从中挑出尽可能多的物品满足以下条件:对于任意两个物品和,满足或者.问最多能挑出多少物品.
//
//        输入描述:
//        第一行输入一个正整数.表示有组数据.
//        对于每组数据,第一行输入一个正整数.表示物品个数.
//        接下来两行,每行有个整数.
//        第一行表示个节点的属性.
//        第二行表示个节点的属性.
//
//
//
//
//        输出描述:
//        输出行,每一行对应每组数据的输出.

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class t1 {
    static class thing{
        int x;
        int y;
        public thing(int x , int y){
            this.x = x;
            this.y = y;
        }
    }





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0){
            int num = scanner.nextInt();
            int[] x = new int[num];
            int[] y = new int[num];
            for (int i = 0 ; i < num ; i++ ){
                x[i] = scanner.nextInt();
            }
            for (int i = 0 ; i < num ; i++ ){
                y[i] = scanner.nextInt();
            }

            thing[] things = new thing[num];
            for (int i = 0 ; i < num ; i++ ){
                things[i] = new thing(x[i] , y[i]);
            }

            Arrays.sort(things, new Comparator<thing>() {
                @Override
                public int compare(thing a, thing b) {
                    if(a.x != b.x){
                        return a.x - b.x;
                    }else {
                        return a.y - b.y;
                    }
                }
            });

            for (int i = 0 ; i < num ; i++ ){
                System.out.println(" "+things[i].x +"  "+things[i].y);
            }


            int ret = 1;
            int max = 0;
            for(int i = 1 ; i < num ; i++ ){
                if(things[i].y > things[i-1].y ){
                    ret++;
                    max = Math.max(ret , max);
                }else {
                    ret = 1;
                }
            }
            System.out.println(max);
            T--;
        }
    }
}
