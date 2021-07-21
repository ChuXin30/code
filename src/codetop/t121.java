package codetop;

//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//        你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//        返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

public class t121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][n];

        dp[0][0] = 0;
        dp[1][0] = -prices[0];

        for (int i = 1 ; i < n ; i++ ){
            dp[0][i] = Math.max(dp[0][i-1] , dp[1][i-1] + prices[i]);
            dp[1][i] = Math.max(dp[1][i-1] , - prices[i] ); //只允许交易一次  因此手上的现金数就是当天的股价的相反数
        }
        return  dp[0][n-1] ;
    }
}
