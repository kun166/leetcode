package com.test.leetcode.page2.chapter180.t188;

import org.junit.Test;

/**
 * @ClassName: Solution2025032501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 14:27
 * @Version: 1.0
 */
public class Solution2025032501 {


    @Test
    public void test() {
        System.out.println(maxProfit(2, new int[]{2, 1, 4, 5, 2, 9, 7}));
    }

    /**
     * 动态规划
     * <p>
     * 7ms	击败24.82%
     * 47.38MB	击败5.23%
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        /**
         * dp[i][j][k]
         * 第i天,交易了j次后,手中有股票/手中无股票 时,获取的最大利润
         */
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        /**
         * 初始化第1天的情况
         */
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            // 第i+1天,交易0次,手中没有股票和手中有股票时,获取的最大利润
            dp[i][0][0] = 0;
            /**
             * 呃，第一次把下面的代码写成了
             * dp[i][0][1] = -prices[i]
             */
            dp[i][0][1] = Math.max(dp[i - 1][0][1], -prices[i]);
            for (int j = 1; j <= k; j++) {
                /**
                 * 第i+1天,交易j次,手中没有股票时,获取的最大利润。
                 * 1,第i天,交易j次,手中没有股票时,获取的最大利润。
                 * 2,第i天,交易j-1次,手中有股票,今天卖了,获取的最大利润。
                 */
                dp[i][j][0] = Math.max(dp[i - 1][j][0], prices[i] + dp[i - 1][j - 1][1]);

                /**
                 * 第i+1天,交易j次,手中有股票时,获取的最大利润。
                 * 1,第i天,交易j次,手中有股票时,获取的最大利润
                 * 2,第i天,交易j-1次,手中无股票时,获取的最大利润
                 */
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
