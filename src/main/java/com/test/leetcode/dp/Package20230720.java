package com.test.leetcode.dp;

import org.junit.Test;

/**
 * @ClassName: Package20230720
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/20 09:39
 * @Version: 1.0
 */
public class Package20230720 {

    @Test
    public void test() {
        System.out.println(maxValue(3, 5, new int[]{4, 2, 3}, new int[]{4, 2, 3}));
    }

    public int maxValue(int n, int c, int[] v, int[] w) {
        // dp[i][j]表示前i件物品，在j的容量下的最大价值
        int[][] dp = new int[n + 1][c + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            // 反向可以把dp变成一维的
            for (int j = 0; j <= c; j++) {
                // 当前物品不选
                dp[i][j] = dp[i - 1][j];
                if (w[i - 1] <= j) {
                    // 当前物品选
                    dp[i][j] = Math.max(dp[i][j], v[i - 1] + dp[i - 1][j - w[i - 1]]);
                }
            }
        }
        return dp[n][c];
    }
}