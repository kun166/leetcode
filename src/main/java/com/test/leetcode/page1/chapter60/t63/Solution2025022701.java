package com.test.leetcode.page1.chapter60.t63;

/**
 * @ClassName: Solution2025022701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/27 15:46
 * @Version: 1.0
 */
public class Solution2025022701 {

    /**
     * 这题没的说了，只能动态规划了……
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        // 特例吧
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        // 尝试大神说的单维数组。同一行,n列
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            /**
             * 在这出错了
             * dp[i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];
             */
            dp[i] = obstacleGrid[0][i] == 1 ? 0 : dp[i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 逐行遍历
                dp[j] = obstacleGrid[i][j] == 1 ? 0 : j == 0 ? dp[j] : dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
