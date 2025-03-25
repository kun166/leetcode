package com.test.leetcode.page2.chapter180.t188;

/**
 * @ClassName: Solution2025032501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 14:27
 * @Version: 1.0
 */
public class Solution2025032503 {

    /**
     * 动态规划,参考官方解答,继续优化一下空间
     * <p>
     * 1ms	击败99.91%
     * 40.52MB	击败98.17%
     * <p>
     * 空间又减少了一些……
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] dp = new int[k + 1][2];

        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                dp[j][1] = Math.max(dp[j][1], dp[j][0] - prices[i]);
                dp[j][0] = Math.max(dp[j][0], prices[i] + dp[j - 1][1]);
            }
            dp[0][0] = 0;
            dp[0][1] = Math.max(dp[0][1], -prices[i]);
        }
        return dp[k][0];
    }
}
