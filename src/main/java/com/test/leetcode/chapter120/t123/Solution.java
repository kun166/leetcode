package com.test.leetcode.chapter120.t123;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-01 10:42
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            // 第一次买
            buy1 = Math.max(buy1, -prices[i]);
            // 第一次卖
            sell1 = Math.max(sell1, buy1 + prices[i]);
            // 第二次买
            buy2 = Math.max(buy2, sell1 - prices[i]);
            // 第二次卖
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
