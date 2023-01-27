package com.test.leetcode.page2.chapter120.t122;

/**
 * @ClassName: OfficialFirst20230127
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 11:23
 * @Version: 1.0
 */
public class OfficialFirst20230127 {

    /**
     * 动态规划……
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 两个状态,dp[n][0]表示今天手里没有股票;dp[n][1]表示今天手里一只股票
        int[][] dp = new int[n][2];
        // 第一天没买股票
        dp[0][0] = 0;
        // 第一天买了一只股票
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            // 当前手里没有股票，分为两种情况。前一天有一只今天卖了;前一天手里也没股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 当前手里有一只股票,也分为两种情况，昨天手里一只股票，昨天手里没有股票今天买了一只
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        // 第n天手里没股票
        return dp[n - 1][0];
    }
}
