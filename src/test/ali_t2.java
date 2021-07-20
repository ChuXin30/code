package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            int[] num = new int[n];
//
//            for (int i = 0; i < n; i++) {
//                num[i] = scanner.nextInt();
//            }
//
//
//            int flag = 0;
//            ArrayList<Integer> ret = new ArrayList<>();
//
//            while (flag < n){
//                flag = 0;
//                int min = Integer.MAX_VALUE;
//                for(int i = 0 ; i < n ; i++ ){
//                    if( num[i] != 0 ){
//                        min = Math.min(num[i], min);
//                    }
//                }
//
//                for (int i = 0 ; i < n ; i++){
//                    if(num[i]!=0){
//                        num[i] = num[i] - min;
//                    }
//                }
//                for (int i = 0 ; i < n ; i++ ){
//                    if (num[i] == 0){
//                        i++;
//                        while (i < n && num[i] == 0 ){
//                            flag++;
//                            i++;
//                        }
//                    }
//                }
//
////                for (int i = 0 ; i < n ; i++ ){
////                    System.out.print(num[i] + " ");
////                }
////                System.out.println();
////
////                System.out.println(n - flag);
//
//                ret.add(n-flag);
//
//                if(n - flag == 1)break;
//            }
//            int retlen = ret.size();
//            System.out.println(retlen);
//            for (int i = 0 ; i < retlen ; i++ ){
//                System.out.print(ret.get(i) + " ");
//            }
//
//
//        }
//    }
//}



public class ali_t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long[] num = new long[n];

            for (int i = 0; i < n; i++) {
                num[i] = scanner.nextLong();
            }


            long flag = 0;
            ArrayList<Long> ret = new ArrayList<>();

            while (flag < n){
                flag = 0;
                long min = Long.MAX_VALUE;
                for(int i = 0 ; i < n ; i++ ){
                    if( num[i] != 0 ){
                        min = Math.min(num[i], min);
                    }
                }

                for (int i = 0 ; i < n ; i++){
                    if(num[i]!=0){
                        num[i] = num[i] - min;
                    }
                }
//                for (int i = 0 ; i < n ; i++ ){
//                    if (num[i] == 0){
//                        i++;
//                        while (i < n && num[i] == 0 ){
//                            flag++;
//                            i++;
//                        }
//                    }
//                }


                int j = 0;
                while ( j < n ){
                    if (num[j] == 0){
                        j++;
                        while (j < n && num[j] == 0 ){
                            flag++;
                            j++;
                        }
                    }
                    j++;
                }

//                for (int i = 0 ; i < n ; i++ ){
//                    System.out.print(num[i] + " ");
//                }
//                System.out.print("        flag = " + flag);
//
//                System.out.println();
//

                ret.add(n-flag);

                if(n - flag == 1)break;
            }
            int retlen = ret.size();
            System.out.println(retlen);
            for (int i = 0 ; i < retlen ; i++ ){
                System.out.print(ret.get(i) + " ");
            }


        }
    }
}
