package com.test.leetcode.page1.chapter70.t74;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-11 11:01
 */
public class Solution {

    @Test
    public void test() {
//        int[][] matrix = new int[3][4];
//        matrix[0] = new int[]{1, 3, 5, 7};
//        matrix[1] = new int[]{10, 11, 16, 20};
//        matrix[2] = new int[]{23, 30, 34, 50};
//        System.out.println(searchMatrix(matrix, 3));

        int[][] matrix = new int[2][1];
        matrix[0] = new int[]{1};
        matrix[1] = new int[]{3};
        System.out.println(searchMatrix(matrix, 0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        boolean contain = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target)
                    contain = true;
                if (j == 0 && i > 0 && matrix[i][j] <= matrix[i - 1][n - 1]) {
                    return false;
                }
                if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
                    return false;
                }
            }
        }
        return contain;
    }
}
