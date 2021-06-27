package leetcode101.c07;
<<<<<<< HEAD

import java.util.Arrays;

=======
>>>>>>> origin/master
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

<<<<<<< HEAD
public class t188 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int n = prices.length;
            k = Math.min(k, n / 2);
            int[][] buy = new int[n][k + 1];
            int[][] sell = new int[n][k + 1];

            buy[0][0] = -prices[0];
            sell[0][0] = 0;
            for (int i = 1; i <= k; ++i) {
                buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
            }

            for (int i = 1; i < n; ++i) {
                buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
                for (int j = 1; j <= k; ++j) {
                    buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                    sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
                }
            }

            return Arrays.stream(sell[n - 1]).max().getAsInt();
        }
=======
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
>>>>>>> origin/master
    }
}
