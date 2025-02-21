package com.test.leetcode.dp;

import org.junit.Test;

/**
 * @ClassName: Package20230720
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/20 09:39
 * @Version: 1.0
 */
public class PackageSecond20230720 {

    @Test
    public void test() {
        System.out.println(maxValue(3, 5, new int[]{4, 2, 3}, new int[]{4, 2, 3}));
    }

    public int maxValue(int n, int c, int[] v, int[] w) {
        // dp[i][j]表示前i件物品，在j的容量下的最大价值
        int[] dp = new int[c + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 反向可以把dp变成一维的
            for (int j = c; j >= 0; j--) {
                if (w[i - 1] <= j) {
                    // 当前物品选
                    dp[j] = Math.max(dp[j], v[i - 1] + dp[j - w[i - 1]]);
                }
            }
        }
        return dp[c];
    }
}