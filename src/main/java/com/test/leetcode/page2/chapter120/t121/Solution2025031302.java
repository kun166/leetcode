package com.test.leetcode.page2.chapter120.t121;

/**
 * @ClassName: Solution2025031302
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/13 09:53
 * @Version: 1.0
 */
public class Solution2025031302 {

    /**
     * 嗯,单调栈……
     * 3ms 击败22.98%
     * 60.21MB 击败76.17%
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int buyPrice = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - prices[buyPrice]);
            buyPrice = prices[i] < prices[buyPrice] ? i : buyPrice;
        }
        return ans;
    }
}
