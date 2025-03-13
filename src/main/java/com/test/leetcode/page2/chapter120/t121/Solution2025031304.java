package com.test.leetcode.page2.chapter120.t121;

/**
 * @ClassName: Solution2025031304
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/13 10:08
 * @Version: 1.0
 */
public class Solution2025031304 {

    /**
     * 呃，试试吧，不知道这种优化有没有意义
     * 2ms	击败45.17%
     * 60.27MB	击败72.25%
     * <p>
     * 果然没意义……看来1秒的那些都是以前测试用例少的时候……
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0, length = prices.length, minPrice = prices[0], earn;
        for (int i = 1; i < length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else {
                earn = prices[i] - minPrice;
                ans = ans > earn ? ans : earn;
            }
        }
        return ans;
    }
}
