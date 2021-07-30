package mianshi.pdd_jishi;

import java.util.HashMap;
import java.util.Scanner;

public class pdd_t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            int[] pai = new int[n+n];
            for (int i = 0 ; i < n*2 ; i++ ){
                pai[i] = scanner.nextInt();
            }
            int a_count = 0;
            int b_count = 0;


            HashMap<Integer , Integer > hashMap = new HashMap<>();
            int start = -1;
            for (int i = 0 ; i < n*2 ; i++){
                int t = pai[i];
                if( hashMap.containsKey(t) ){
                    int index = hashMap.get(t);
                    if(index > start){
                        if(i %2 == 0)a_count += i-index;
                        else b_count += i - index;
                        start = index;
                    }
                }
            }





            System.out.println(n + " " + n);
        }
    }
}
