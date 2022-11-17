package com.test.leetcode.page1.chapter60.t63;

import org.junit.Test;

/**
 * @ClassName: Solution20221117
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/17 19:35
 * @Version: 1.0
 */
public class Solution20221117 {

    @Test
    public void test() {
        uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 1}, {0, 0}});
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        // 先初始化第一行
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    // 第一列
                    if (obstacleGrid[i][j] == 1) {
                        dp[j] = 0;
                    } else {
                        // 这一步其实可以省略了
                        dp[j] = dp[j];
                    }
                } else {
                    if (obstacleGrid[i][j] == 1) {
                        dp[j] = 0;
                    } else {
                        dp[j] += dp[j - 1];
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
