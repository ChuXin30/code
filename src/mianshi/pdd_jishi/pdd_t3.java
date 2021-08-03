package mianshi.pdd_jishi;

import java.util.Scanner;

public class pdd_t3 {
    static boolean f(int a , int b , int c , int q){
        System.out.println("a="+a + " b="+b + " c="+c + " q="+q);
        if(q <= 0 )return false;
        if( q == a || q== c || q == b    )return true;

        boolean flag = false;
        if( c!= 1 && q%c == 0 ) flag = f(a , b, c ,q/c);

        if(  flag   ||  f( a , b , c , q - b ))return true;
        else return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            for (int i = 0 ; i < n ; i++ ){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                int q = scanner.nextInt();

                if(  f(a,b,c,q) ){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }

//                while (c != 1 && q%c == 0  ){
//                    q = q/c;
////                    System.out.println(""q);
//
//                }

//                System.out.println(q);

//                if( (q-a)%b== 0 || (q-c)%b == 0){
//                    System.out.println(1);
//                }else {
//                    System.out.println(0);
//                }
//                1
//                1111 1 1 545200
//                boolean flag = false;
//                int t = a;
//                while ( t < q){
//                    t += b;
////                    System.out.println("t="+t+" q="+q);
//
//                    if(t == q){
//                        flag = true;
//                        break;
//                    }
//                }
//
//
//                t = c;
//                while (t < q){
//                    t += b;
//                    if(t == q ){
//                        flag = true;
//                        break;
//                    }
//                }
////                System.out.println("t="+t+" q="+q +" flag="+flag);
//
//                if(flag){
//                    System.out.println(1);
//                }else {
//                    System.out.println(0);
//                }

            }
        }
    }
}
