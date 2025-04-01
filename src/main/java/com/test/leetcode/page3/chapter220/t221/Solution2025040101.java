package com.test.leetcode.page3.chapter220.t221;

/**
 * @ClassName: Solution2025040101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 10:16
 * @Version: 1.0
 */
public class Solution2025040101 {

    /**
     * 嗯哼,超出时间限制……
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    ans = Math.max(ans, maximalSquare(matrix, i, j));
                }
            }
        }
        return ans;
    }

    /**
     * 以row,column为左顶点,查找最大的正方面积
     *
     * @param matrix
     * @param row
     * @param column
     * @return
     */
    public int maximalSquare(char[][] matrix, int row, int column) {
        // 定义边长
        int length = 2;
        while (true) {
            // 每一次增加一个单位的边长,需要遍历两个边
            // 1,底边
            int maxRow = row + length - 1;
            int maxColumn = column + length - 1;
            if (maxRow >= matrix.length || maxColumn >= matrix[0].length) {
                // 越界了
                return (length - 1) * (length - 1);
            }
            for (int i = column; i <= maxColumn; i++) {
                if (matrix[maxRow][i] == '0')
                    return (length - 1) * (length - 1);
            }
            for (int i = row; i <= maxRow; i++) {
                if (matrix[i][maxColumn] == '0')
                    return (length - 1) * (length - 1);
            }
            length++;
        }
    }
}
