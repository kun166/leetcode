package com.test.leetcode.page1.chapter60.t64;

/**
 * @ClassName: Solution2025022701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/27 16:11
 * @Version: 1.0
 */
public class Solution2025022701 {

    /**
     * 这题应该也是个动态规划题吧？
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        // 唉，算了,不破坏原来grid了
        int m = grid.length, n = grid[0].length;
        // 同一行的列,按行从上向下遍历
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    dp[j] = (j > 0 ? dp[j - 1] : 0) + grid[i][j];
                else if (j == 0)
                    dp[j] += grid[i][j];
                else
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
