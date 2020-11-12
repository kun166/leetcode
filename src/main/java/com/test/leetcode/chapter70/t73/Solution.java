package com.test.leetcode.chapter70.t73;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-10 20:12
 */
public class Solution {

    @Test
    public void test() {
        //int[][] matrix = new int[3][3];
        //matrix
    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        int add = 1;
        //第一遍遍历，把所有正数+1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0)
                    matrix[i][j] += 1;
            }
        }

        //第二遍遍历，把原来位置不为0但是要修改为0的修改为1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 把原来位置不为0但是要修改为0的修改为1
                    for (int a = 0; a < m; a++) {
                        if (matrix[a][j] != 0)
                            matrix[a][j] = 1;
                    }
                    for (int a = 0; a < n; a++) {
                        if (matrix[i][a] != 0)
                            matrix[i][a] = 1;
                    }
                }
            }
        }
        // 第三遍遍历,将1的修改为0，将大于1的数减1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    matrix[i][j] = 0;
                else if (matrix[i][j] > 1)
                    matrix[i][j] -= 1;
            }
        }
    }
}
