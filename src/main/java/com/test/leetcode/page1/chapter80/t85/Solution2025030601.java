package com.test.leetcode.page1.chapter80.t85;

import org.junit.Test;

/**
 * @ClassName: Solution2025030601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/6 09:37
 * @Version: 1.0
 */
public class Solution2025030601 {

    @Test
    public void test() {
        char[][] matrix = new char[][]{
                {'0', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    /**
     * 先根据自己理解做一遍吧。
     * <p>
     * 虽然修改了好多版，但是总算通过了？
     * 9ms 击败70.51%
     * 47.21MB 击败5.11%
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        // 遍历整个矩阵,只从等于1的开始寻找
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // 剪枝吧
                    if (maxArea >= (m - i) * (n - j)) {
                        if (j == 0)
                            return maxArea;
                        // 继续循环i
                        break;
                    }
                    maxArea = Math.max(maxArea, maximalRectangle(matrix, i, j));
                }
            }
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix, int row, int col) {
        int maxArea = 0, m = matrix.length - 1, n = matrix[0].length - 1;
        for (int i = row; i <= m; i++) {
            for (int j = col; j <= n; j++) {
                if (matrix[i][j] == '0') {
                    // 取该点左侧矩形面积。
                    maxArea = Math.max(maxArea, (i - row + 1) * (j - col));
                    // 取该点上方矩形面积
                    maxArea = Math.max(maxArea, (i - row) * (n - col + 1));
                    n = j - 1;
                    if (j == col) {
                        return maxArea;
                    }
                }
            }
        }
        maxArea = Math.max(maxArea, (m - row + 1) * (n - col + 1));
        return maxArea;
    }
}
