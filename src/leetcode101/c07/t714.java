package leetcode101.c07;

//714. 买卖股票的最佳时机含手续费
//        给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
//
//        你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
//
//        返回获得利润的最大值。
//
//        注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
//
//        示例 1:
//
//        输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
//        输出: 8
//        解释: 能够达到的最大利润:
//        在此处买入 prices[0] = 1
//        在此处卖出 prices[3] = 8
//        在此处买入 prices[4] = 4
//        在此处卖出 prices[5] = 9
//        总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

/*
定义状态 \textit{dp}[i][0]dp[i][0] 表示第 ii 天交易完后手里没有股票的最大利润，\textit{dp}[i][1]dp[i][1] 表示第 ii 天交易完后手里持有一支股票的最大利润


 */

public class t714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] have = new int[n];
        int[] nothave = new int[n];

        have[0] = -prices[0];
        for(int i = 1 ; i < n ; i++ ){
            nothave[i] = Math.max( have[i-1] + prices[i] -fee , nothave[i-1] );
            have[i] = Math.max(  nothave[i-1] - prices[i] , have[i-1]  );
        }
        return  Math.max(nothave[n-1] , have[n-1]);
    }
}
