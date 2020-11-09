package com.test.leetcode.chapter60.t62;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-09 10:12
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {

        int[][] array = new int[m][n];
        array[0][0] = 1;
        for (int i = 1; i < m; i++) {
            array[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            array[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m - 1][n - 1];
    }
}
