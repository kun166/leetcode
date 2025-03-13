package com.test.leetcode.page2.chapter120.t123;

/**
 * @ClassName: Official2025031301
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/13 15:23
 * @Version: 1.0
 */
public class Official2025031301 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        /**
         * 第一次操作股票,buy1持有股票,sell1未吃有股票
         */
        int buy1 = -prices[0], sell1 = 0;
        /**
         * 第二次操作股票,buy2持有股票(可以理解为买了卖了又买了),sell2未持有股票
         */
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
