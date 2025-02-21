package com.test.leetcode.page1.chapter60.t64;

/**
 * @ClassName: Solution20230705
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/5 16:24
 * @Version: 1.0
 */
public class Solution20230705 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了92.21%的用户
     * 内存消耗：42.7 MB, 在所有 Java 提交中击败了82.08%的用户
     * 通过测试用例：61 / 61
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[j] = grid[i][j];
                    } else {
                        dp[j] = dp[j - 1] + grid[i][j];
                    }
                } else if (j == 0) {
                    dp[j] += grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}
