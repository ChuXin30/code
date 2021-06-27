package leetcode101.c07;
//188. 买卖股票的最佳时机 IV
//        给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
//
//        设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
//        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//
//
//        示例 1：
//
//        输入：k = 2, prices = [2,4,1]
//        输出：2
//        解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
//        示例 2：
//
//        输入：k = 2, prices = [3,2,6,5,0,3]
//        输出：7
//        解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//        随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

/*
使用动态规划来做
使用两个数组一个为buy， buy[i] 标识第i次 买入股票的最大收入
sell[j] 标识第j次 卖出股票的最大收入。
 */

import java.util.Arrays;

public class t188 {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        if(days < 2)return 0;
        if(k > days){
            return maxprofitUnlimited( prices);
        }
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0 ; i < days ; i++){
            for (int j = 1 ; j <= k ; j++){
                buy[j] = Math.max(buy[j] , sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j] , buy[j] + prices[i]);
            }
        }
        return sell[k];
    }
    int maxprofitUnlimited(int[] prices){
        int maxProfit = 0 ;
        for (int i = 1 ; i < prices.length ; i++){
            maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }
}
