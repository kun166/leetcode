package com.test.leetcode.page2.chapter120.t122;

/**
 * @ClassName: OfficialSecond20230127
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 11:28
 * @Version: 1.0
 */
public class OfficialSecond20230127 {

    /**
     * 贪心算法
     * 呃，再看这代码,真的思路不一样就是不一样……
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
