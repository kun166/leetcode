package com.test.leetcode.page1.chapter60.t63;

/**
 * @ClassName: Solution20230705
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/5 14:49
 * @Version: 1.0
 */
public class Solution20230705 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
