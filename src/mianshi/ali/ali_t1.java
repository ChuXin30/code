package mianshi.ali;

import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ali_t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] num = new int[n];
            for (int i = 0 ; i < n ; i++ ){
                num[i] = scanner.nextInt();
            }

//            LinkedList<Integer> linkedList = new LinkedList<>();
//            for (int i = 0 ; i < n ; i++){
//                if(i%2 == 0)linkedList.addLast(num[i]);
//                else linkedList.addFirst(num[i]);
//            }
//
//            if(n%2 == 1){
//                for (int i = 0 ; i < n-1 ; i++ ){
//                    System.out.print(linkedList.get(i)+" ");
//                }
//                System.out.println(linkedList.get(n-1));
//            }else {
//                for (int i = n-1 ; i > 0 ; i--){
//                    System.out.print(linkedList.get(i)+ " ");
//                }
//                System.out.println(linkedList.get(0));
//            }

            int[] ret = new int[n];
            int mid = (n-1)/2;
            int left = 0;
            int right = 1;
            for (int i = 0 ; i < n ; i++){
                if(i%2 == 0){
                    ret[ mid - left ] = num[i];
                    left++;
                }else {
                    ret[mid + right] = num[i];
                    right++;
                }
//                for (int j = 0 ; j < n ; j++ ){
//                    System.out.print(ret[j]+" ");
//                }
//                System.out.println();
            }


            if(n%2 == 0){
                for (int i = 0 ; i < n-1 ; i++ ){
                    System.out.print(ret[i]+" ");
                }
                System.out.println(ret[n-1]);
            }else {
                for (int i = n-1 ; i > 0 ; i--){
                    System.out.print(ret[i]+ " ");
                }
                System.out.println(ret[0]);
            }
        }
    }
}
