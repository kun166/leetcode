package com.test.leetcode.page3.chapter240.t240;

import org.junit.Test;

/**
 * @ClassName: SolutionThird20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 09:44
 * @Version: 1.0
 */
public class SolutionThird20230310 {

    @Test
    public void test() {
        System.out.println(searchMatrix(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}, 5));
    }

    /**
     * 二分吧，试试这个二分如何
     * <p>
     * 呃，6毫秒，击败39%
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0, left, right;
        while (i < m) {
            // 无非就是三种情况
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                left = j;
                right = n - 1;
            } else {
                if (j <= 0) {
                    return false;
                }
                left = 0;
                right = j;
            }
            while (left <= right) {
                int mid = left + ((right - left) >> 2);
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            j = left >= n ? n - 1 : left;
            i++;
        }
        return false;
    }
}
