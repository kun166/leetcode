package com.test.leetcode.page3.chapter220.t221;

/**
 * @ClassName: OfficialSecond20230228
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/28 10:31
 * @Version: 1.0
 */
public class OfficialSecond20230228 {

    /**
     * 方法二：动态规划
     * <p>
     * 呃， 这个的思路就是dp[i,j]以坐标[i,j]为右下角，计算正方形最大边长
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 三个点的最小值+1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
