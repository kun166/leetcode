package com.test.leetcode.page2.chapter120.t122;

/**
 * @ClassName: Solution2025031301
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/13 10:27
 * @Version: 1.0
 */
public class Solution2025031301 {

    /**
     * 这不知道算是贪心，还是dp，还是单调栈……
     * 0ms	击败100.00%
     * 44.94MB	击败40.68%
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0, n = prices.length, buy = prices[0];
        for (int i = 1; i < n; i++) {
            /**
             * 下面代码是由
             * if (prices[i] < buy)
             *     buy = prices[i];
             * else {
             *     ans += prices[i] - buy;
             *     buy = prices[i];
             * }
             * 优化而来
             */
            if (prices[i] > buy)
                ans += prices[i] - buy;
            buy = prices[i];
        }
        return ans;
    }
}
