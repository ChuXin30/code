package leetcode101.c07;


//583. 两个字符串的删除操作
//        给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
//
//
//
//        示例：
//
//        输入: "sea", "eat"
//        输出: 2
//        解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
//
//
//        提示：
//
//        给定单词的长度不超过500。
//        给定单词中的字符只含有小写字母。

/*
设计一个二维数组
dp[i][j] 代表到dp[i][j]所需的最小操作

 */

public class t583 {
    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];

        for (int i = 0 ; i <= n1 ; i++){
            for (int j = 0 ; j <= n2 ; j++){
                if(i == 0 || j == 0) dp[i][j] = Math.max(i , j) ;
            }
        }

        for (int i = 1 ; i <= n1 ; i++){
            for (int j = 1 ; j <= n2 ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min( dp[i-1][j] , dp[i][j-1] ) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        minDistance("sea" , "eat");
    }
}
