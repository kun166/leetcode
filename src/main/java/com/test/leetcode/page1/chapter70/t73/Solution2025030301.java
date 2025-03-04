package com.test.leetcode.page1.chapter70.t73;

/**
 * @ClassName: Solution2025030301
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/3 09:40
 * @Version: 1.0
 */
public class Solution2025030301 {

    /**
     * 这题的难点，应该就是找那个替代数，即在整个矩阵里面都没有的数。
     * <p>
     * 感觉搞不定……,只能想到申请m+n个空间了……
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] columns = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        // 第二次遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || columns[j])
                    matrix[i][j] = 0;
            }
        }
    }
}
