package mianshi.tensent_bishi;

import java.util.*;

public class t2 {
    static class node{
        int key;
        int zhi;
        public node(int key , int zhi){
            this.key = key;
            this.zhi = zhi;
        }
    }

    static public int get(int n){
        int count = 1;
        if(n <= 1) return 1;
        for (int i = 1 ; i <= n/2 ; i++){
            if(n%i == 0)count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int[] hash = new int[100001];

            for (int i = 0 ; i < n ; i++ ){
                a[i] = scanner.nextInt();
                hash[a[i]]++;
            }
            for (int i = 0 ; i < n ; i++ ){
                b[i] = scanner.nextInt();
            }

            int[] b_zhi = new int[n];
            node[] a_node = new node[n];
            for (int i = 0 ; i < n ; i++ ){
                a_node[i] = new node(a[i] , get(a[i]));
                b_zhi[i] = get(b[i]);
            }

            Arrays.sort(a_node, new Comparator<node>() {
                @Override
                public int compare(node a, node b) {
                    return a.zhi - b.zhi;
                }
            });

//            for (int i = 0 ; i < n ; i++ ){
//                System.out.println("key= "+ a_node[i].key + " zhi="+a_node[i].zhi);
//                System.out.println("b_zhi="+b_zhi[i]);
//
//            }


            int count = 0;

            for (int i = 0 ; i < n ; i++ ){
                int num_b = b_zhi[i];
                for(int j = 0 ; j < n ; j++ ){
                    int key_a = a_node[j].key;
                    int zhi_a = a_node[j].zhi;

                    if( hash[key_a] > 0 && zhi_a > num_b){
                        count++;
                        hash[key_a]--;
                        break;
                    }
                }
            }
            System.out.println(count);


//            Arrays.sort(b);
//            Arrays.sort(a);
//            int max = a[n-1];

//            int count = 0;

//            for (int i = 0 ; i < n ; i++){
//                for (int j = 0 ; j < n  ; j++ ){
//                    if(hash[a[j]] > 0 && a[j] >  b[i]  && a[j]%b[i] == 0 ){
////                        System.out.println(a[j] + " " + b[i]);
//                        count++;
//                        hash[a[j]]--;
//                        break;
//                    }
//                }
//            }

//            System.out.println(count);

        }
    }
}
