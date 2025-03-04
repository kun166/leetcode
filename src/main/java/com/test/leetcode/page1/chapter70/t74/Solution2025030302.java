package com.test.leetcode.page1.chapter70.t74;

import org.junit.Test;

/**
 * @ClassName: Solution2025030302
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/3 10:44
 * @Version: 1.0
 */
public class Solution2025030302 {

    @Test
    public void test() {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }

    /**
     * 继续二分,来个全矩阵二分吧
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 先来个速算吧?
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        int left = 0, right = m * n - 1;
        while (left <= right) {
            /**
             * 唉唉唉，这种left = mid + 1和right = mid - 1的
             * 必须left<=right啊
             */
            int mid = left + ((right - left) >> 1);
            int number = matrix[mid / n][mid % n];
            if (number == target) {
                return true;
            } else if (number < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
