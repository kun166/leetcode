package com.test.leetcode.page4.chapter320.t329;

/**
 * @ClassName: Solution20230425
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/25 09:23
 * @Version: 1.0
 */
public class Solution20230425 {

    int ans = 0;

    /**
     * 超出时间限制
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestIncreasingPath(matrix, j, i, 1);
            }
        }
        return ans;
    }

    public void longestIncreasingPath(int[][] matrix, int x, int y, int count) {
        ans = Math.max(ans, count);
        // 向四边寻找
        // 向上寻找
        if (y > 0 && matrix[y - 1][x] > matrix[y][x]) {
            longestIncreasingPath(matrix, x, y - 1, count + 1);
        }
        // 向下寻找
        if (y < matrix.length - 1 && matrix[y + 1][x] > matrix[y][x]) {
            longestIncreasingPath(matrix, x, y + 1, count + 1);
        }
        // 向左寻找
        if (x > 0 && matrix[y][x - 1] > matrix[y][x]) {
            longestIncreasingPath(matrix, x - 1, y, count + 1);
        }
        // 向右寻找
        if (x < matrix[0].length - 1 && matrix[y][x + 1] > matrix[y][x]) {
            longestIncreasingPath(matrix, x + 1, y, count + 1);
        }
    }
}
