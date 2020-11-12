package com.test.leetcode.chapter70.t74;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-11 15:28
 */
public class Solution20201111 {

    @Test
    public void test() {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 3, 5, 7};
        matrix[1] = new int[]{10, 11, 16, 20};
        matrix[2] = new int[]{23, 30, 34, 50};
        System.out.println(searchMatrix(matrix, 3));

//        int[][] matrix = new int[2][1];
//        matrix[0] = new int[]{1};
//        matrix[1] = new int[]{3};
        System.out.println(searchMatrix(matrix, 0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int n = matrix[0].length;
        int start = 0, end = matrix.length * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int value = getMatrixValue(matrix, n, mid);
            if (value == target)
                return true;
            if (value > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

    public int getMatrixValue(int[][] matrix, int n, int index) {
        int i = index / n;
        int j = index - i * n;
        return matrix[i][j];
    }
}
