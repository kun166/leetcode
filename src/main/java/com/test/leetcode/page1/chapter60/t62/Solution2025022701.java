package com.test.leetcode.page1.chapter60.t62;

import java.util.Arrays;

/**
 * @ClassName: Solution20250227
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/27 15:02
 * @Version: 1.0
 */
public class Solution2025022701 {

    /**
     * 这题只能动态规划么?
     * <p>
     * 呃，想起来上次做这题,好像是组合？c(m+n,m)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化数据dp[i][j],当i==0或者j==0的时候,都只有一种选择
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 上方+左侧
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
