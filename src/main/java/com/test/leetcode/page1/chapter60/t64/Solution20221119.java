package com.test.leetcode.page1.chapter60.t64;

/**
 * @ClassName: Solution20221119
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/19 13:20
 * @Version: 1.0
 */
public class Solution20221119 {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[j] = grid[i][j] + (j > 0 ? dp[j - 1] : 0);
                } else {
                    dp[j] = grid[i][j] + (j > 0 ? Math.min(dp[j - 1], dp[j]) : dp[j]);
                }
            }
        }
        return dp[n - 1];
    }
}
