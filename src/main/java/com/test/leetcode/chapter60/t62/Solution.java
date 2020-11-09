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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 1;
                } else
                    array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m - 1][n - 1];
    }
}
