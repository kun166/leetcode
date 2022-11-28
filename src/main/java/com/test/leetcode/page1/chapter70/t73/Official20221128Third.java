package com.test.leetcode.page1.chapter70.t73;

/**
 * @ClassName: Official20221128Third
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/28 19:33
 * @Version: 1.0
 */
public class Official20221128Third {

    /**
     * 我们可以对方法二进一步优化，只使用一个标记变量记录第一列是否原本存在0。
     * 这样，第一列的第一个元素即可以标记第一行是否出现0。
     * 但为了防止每一列的第一个元素被提前更新，我们需要从最后一行开始，倒序地处理矩阵元素。
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 第一列是否包含0
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }
}
