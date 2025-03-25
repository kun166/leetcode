package com.test.leetcode.page2.chapter180.t188;

/**
 * @ClassName: Solution2025032501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 14:27
 * @Version: 1.0
 */
public class Solution2025032502 {

    /**
     * 动态规划,优化一下空间
     * <p>
     * 1ms	击败99.91%
     * 40.58MB	击败93.53%
     * <p>
     * 呃,不可思议,优化了空间,耗时居然也少了……
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        int[][] dp = new int[k + 1][2];

        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                /**
                 * 注意顺序……
                 */
                dp[j][1] = Math.max(dp[j][1], dp[j][0] - prices[i]);
                dp[j][0] = Math.max(dp[j][0], prices[i] + dp[j - 1][1]);
            }
            dp[0][0] = 0;
            dp[0][1] = Math.max(dp[0][1], -prices[i]);
        }
        return dp[k][0];
    }
}
