package com.test.leetcode.chapter40.t48;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-30 11:17
 */
public class Solution {

    @Test
    public void test() {
        int[][] matrix = new int[3][3];
        int start = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ++start;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
        }

        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
        }

    }


    public void rotate(int[][] matrix) {
        int lenght = matrix.length;

        //先以00为中心，将matrix[i][j]横纵坐标互换
        for (int i = 0; i < lenght; i++) {
            for (int j = i; j < lenght; j++) {
                int mid = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = mid;
            }
        }

        // i不变，j互换
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght / 2; j++) {
                int mid = matrix[i][j];
                matrix[i][j] = matrix[i][lenght - 1 - j];
                matrix[i][lenght - 1 - j] = mid;
            }
        }
    }
}
