package com.test.leetcode.page1.chapter70.t73;

/**
 * @ClassName: Solution20221125
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/25 10:59
 * @Version: 1.0
 */
public class Solution20221125First {

    public void setZeroes(int[][] matrix) {
        // 使用m+n
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (!row[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!column[i]) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                matrix[j][i] = 0;
            }
        }
    }
}
