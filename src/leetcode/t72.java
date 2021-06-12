package leetcode;

public class t72 {



    public static int minDistance1(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int i = 0 ; i <= n1 ; i++ ){
            dp[i][0] = i;
        }
        for(int i = 0 ; i <= n2 ; i++ ){
            dp[0][i] = j;
        }

        for(int i = 1 ; i <= n1 ; i++ ){
            for (int j = 1 ; j <= n2 ; j++ ){
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                if( c1 == c2 ){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(  Math.min( dp[i][j-1] , dp[i-1][j] ) , dp[i-1][j-1] ) + 1;
                }
            }
        }

        return dp[n1-1][n2-1] ;
    }



    public static int minDistance(String word1, String word2) {



        if(word1.length() == 0 || word2.length() ==0){
            return Math.max(word1.length() , word2.length());
        }
        String word1_1 = word1.substring(0 , word1.length()-1);
        String word2_1 = word2.substring(0 ,word2.length()-1);
        if( word1.charAt(word1.length()-1) == word2.charAt(word2.length()-1) ){
            return minDistance( word1.substring(0 , word1.length()-1) , word2.substring(0 ,word2.length()-1) );
        }
        int min1 =Math.min( minDistance( word1 , word2_1 ) , minDistance( word1_1 , word2 ) );
        int min2 = Math.min( min1 , minDistance( word1_1 , word2_1 ) );
        return 1 + min2 ;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse" , "ros"));
    }
}
