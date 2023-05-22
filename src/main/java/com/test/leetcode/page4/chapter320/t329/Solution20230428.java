package com.test.leetcode.page4.chapter320.t329;

/**
 * @ClassName: Solution20230428
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/28 15:14
 * @Version: 1.0
 */
public class Solution20230428 {

    // 方向，分表标识向上，向下，向左，向右
    int[][] dis = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了79.10%的用户
     * 内存消耗：42.8 MB, 在所有 Java 提交中击败了5.03%的用户
     * 通过测试用例：138 / 138
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int[][] record = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, longestIncreasingPath(matrix, i, j, record));
            }
        }
        return ans;
    }

    public int longestIncreasingPath(int[][] matrix, int y, int x, int[][] record) {

        if (record[y][x] != 0) {
            return record[y][x];
        }
        int ans = 0;
        for (int[] d : dis) {
            int newY = y + d[0], newX = x + d[1];
            if (newY < 0 || newY >= matrix.length || newX < 0 || newX >= matrix[0].length) {
                continue;
            }
            if (matrix[newY][newX] > matrix[y][x]) {
                ans = Math.max(ans, longestIncreasingPath(matrix, newY, newX, record));
            }
        }
        record[y][x] = ans + 1;
        return ans + 1;
    }
}
