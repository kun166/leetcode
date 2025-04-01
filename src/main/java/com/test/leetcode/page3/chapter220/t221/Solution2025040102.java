package com.test.leetcode.page3.chapter220.t221;

/**
 * @ClassName: Solution2025040101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 10:16
 * @Version: 1.0
 */
public class Solution2025040102 {

    /**
     * 5ms	击败99.10%
     * 55.00MB	击败95.75%
     * <p>
     * 呃,呃,有点吃惊……效果这么明显么?
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int length = 0;
        int m = matrix.length, n = matrix[0].length;

        // 1,先初始化以当前作为为起点,左侧连续的1的数量
        // 1.1 初始化第一列
        int[][] matLeft = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                matLeft[i][0] = 1;
                length = 1;
            }
        }
        // 1.2 初始化其余列
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    matLeft[i][j] = matLeft[i][j - 1] + 1;
                    length = 1;
                }
            }
        }
        // 加一个剪枝速判吧
        if (length == 0)
            return 0;
        // 2,初始化以当前作为为起点,上侧连续的1的数量
        int[][] matUp = new int[m][n];
        // 2.1 初始化行
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                matUp[0][i] = 1;
            }
        }
        // 2.2 初始化其余行
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    matUp[i][j] = matUp[i - 1][j] + 1;
                }
            }
        }
        // 3,遍历每一个点,找最大边长
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int l = Math.min(matLeft[i][j], matUp[i][j]);
                matUp[i][j] = Math.min(l, matUp[i - 1][j - 1] + 1);
                length = Math.max(length, matUp[i][j]);
            }
        }
        return length * length;
    }
}
