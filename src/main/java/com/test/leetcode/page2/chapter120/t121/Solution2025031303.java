package com.test.leetcode.page2.chapter120.t121;

/**
 * @ClassName: Solution2025031303
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/13 10:00
 * @Version: 1.0
 */
public class Solution2025031303 {

    /**
     * 由{@link Solution2025031302}优化而来
     * <p>
     * 2ms  击败45.17%
     * 60.35MB  击败65.83%
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int buyPrice = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[buyPrice])
                buyPrice = i;
            else
                ans = Math.max(ans, prices[i] - prices[buyPrice]);
        }
        return ans;
    }
}
