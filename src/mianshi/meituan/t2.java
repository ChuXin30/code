package mianshi.meituan;

import java.util.*;


public class t2 {

    static int[][] ret ;
    static boolean[][] dp;

    static int dfs(boolean[][] visit , int start , int end ){
        int count = 1;
        Deque<Integer> node = new LinkedList<>();
        node.add( start );
        while ( !node.isEmpty() ){
            int size = node.size();
            for (int i = 0 ; i < size ; i++ ){
                int s = node.poll();
                if( dp[s][end] ){
                    return ret[s][end] + count;
                }

                for(int j = 0 ; j < visit.length ; j++ ){
                    if(visit[s][j] == true && start != j ){
                        node.offer(j);

                        ret[start][j] = count;
                        ret[j][start] = count;
                        dp[start][j] = true;
                        dp[j][start] = true;

                        if(j == end)return count;
                    }
                }
            }
            count++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            /*
            1->1
            2->1
            2->2
            3->2
             */


            boolean[][] visited = new boolean[n][n];
            dp = new boolean[n][n];
            ret = new int[n][n];

            for (int i = 0 ; i < n ; i++ ){
                for (int j = 0 ; j < n ; j++ ){
                    ret[i][j] = -1;
                }
                ret[i][i] = 0;
            }

            for (int i = 0; i < n ; i++ ){
                int num = scanner.nextInt();
                visited[i][i] = true;
                dp[i][i] = true;
                for (int j = 0 ; j < num ; j++ ){
                    int end = scanner.nextInt();
                    visited[i][end-1] = true;
                    visited[end-1][i] = true;
                }
            }

//            for (int i = 0 ; i< n ; i++ ){
//                for (int j = 0 ; j < n-1 ; j++ ){
//                    System.out.print( visited[i][j] + " " );
//                }
//                System.out.println(visited[i][n-1]);
//            }


            for(int i = 0 ; i < n ; i++ ){
                for (int j = i+1 ; j < n ; j++ ){
                    int path = dfs( visited , i , j );
                    ret[i][j] =  Math.min( ret[i][j] , path)  ;
                    ret[j][i] = Math.min( ret[i][j] , path) ;
                    dp[i][j] = true;
                    dp[j][i] = true;
                }
            }

            for (int i = 0 ; i< n ; i++ ){
                for (int j = 0 ; j < n-1 ; j++ ){
                    if(dp[i][j]){
                        System.out.print( ret[i][j] + " " );
                    }else {
                        System.out.print( "-1" + " " );
                    }
                }
                if(dp[i][n-1]){
                    System.out.println(ret[i][n-1]);
                }else {
                    System.out.println("-1");
                }
            }



        }
    }
}
