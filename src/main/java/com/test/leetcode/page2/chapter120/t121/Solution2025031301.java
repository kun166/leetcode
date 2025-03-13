package com.test.leetcode.page2.chapter120.t121;

/**
 * @ClassName: Solution2025031301
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/13 09:35
 * @Version: 1.0
 */
public class Solution2025031301 {

    /**
     * 先来个最简单的
     * 双循环
     * <p>
     * 呃，好吧，超出时间限制……
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                /**
                 * 第i天买的股票，第j天卖
                 */
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }
        return ans;
    }
}
