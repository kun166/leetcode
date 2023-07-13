package com.test.leetcode.page6.chapter500.t502;

import org.junit.Test;

/**
 * @ClassName: Solution20230712
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/12 15:32
 * @Version: 1.0
 */
public class Solution20230712 {

    @Test
    public void test() {
        System.out.println(findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 9, 10}));
    }

    /**
     * 好吧，这种方式不太行啊
     *
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        k = Math.min(k, n);
        // dp[i][j]表示前i次投资，投资了j次，最大利润
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = w;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                dp[i][j] = dp[i - 1][j - 1];
                // 本次买
                if (dp[i - 1][j - 1] >= capital[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + profits[i - 1];
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }
        return dp[n][k];
    }
}
