package com.test.leetcode.page1.chapter40.t48;

/**
 * @ClassName: Solution2025022501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/25 15:00
 * @Version: 1.0
 */
public class Solution2025022501 {

    /**
     * 先用官方的解法解一次吧
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        // 1,根据左上右下对角线互换位置
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 2,左右互换
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - 1 - j];
                matrix[i][length - 1 - j] = temp;
            }
        }
    }
}
