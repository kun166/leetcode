package com.test.leetcode.page3.chapter240.t240;

/**
 * @ClassName: Solution20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 08:56
 * @Version: 1.0
 */
public class SolutionFirst20230310 {

    /**
     * 效率不是很高,但是很简单的方式
     * 11ms，击败11%
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] > target) {
                return false;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    break;
                }
            }
        }
        return false;
    }
}
