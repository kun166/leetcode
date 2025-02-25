package com.test.leetcode.page1.chapter40.t48;

/**
 * @ClassName: Solution2025022502
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/25 15:33
 * @Version: 1.0
 */
public class Solution2025022502 {

    /**
     * 呃，这个尝试了好多次，唉唉唉
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int up, down, left, right;
        up = left = 0;
        down = right = length - 1;
        while (left < right) {
            int step = right - left;
            for (int i = 0; i < step; i++) {
                // 一共四次交换
                int temp = matrix[up][left + i];
                matrix[up][left + i] = matrix[down - i][left];
                matrix[down - i][left] = matrix[down][right - i];
                matrix[down][right - i] = matrix[up + i][right];
                matrix[up + i][right] = temp;
            }
            up++;
            down--;
            left++;
            right--;
        }
    }
}
