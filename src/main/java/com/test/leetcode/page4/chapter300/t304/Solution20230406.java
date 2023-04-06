package com.test.leetcode.page4.chapter300.t304;

/**
 * @ClassName: Solution20230406
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/6 10:25
 * @Version: 1.0
 */
public class Solution20230406 {

    class NumMatrix {

        int[][] myMatrix;

        /**
         * 执行用时：96 ms, 在所有 Java 提交中击败了99.94%的用户
         * 内存消耗：67.7 MB, 在所有 Java 提交中击败了7.85%的用户
         * 通过测试用例：22 / 22
         *
         * @param matrix
         */
        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            myMatrix = new int[m][n];
            // 从上向下加
            // 初始化第一行
            for (int i = 0; i < n; i++) {
                myMatrix[0][i] = matrix[0][i];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    myMatrix[i][j] = myMatrix[i - 1][j] + matrix[i][j];
                }
            }
            // 从左向右加
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    myMatrix[i][j] = myMatrix[i][j - 1] + myMatrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return myMatrix[row2][col2]
                    - (row1 > 0 ? myMatrix[row1 - 1][col2] : 0)
                    - (col1 > 0 ? myMatrix[row2][col1 - 1] : 0)
                    + (row1 > 0 && col1 > 0 ? myMatrix[row1 - 1][col1 - 1] : 0);
        }
    }
}
