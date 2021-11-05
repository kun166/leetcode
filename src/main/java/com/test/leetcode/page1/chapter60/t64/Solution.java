package com.test.leetcode.page1.chapter60.t64;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-09 14:24
 */
public class Solution {

    @Test
    public void test() {
        int[][] grid = new int[3][3];
        grid[0] = new int[]{1, 3, 1};
        grid[1] = new int[]{1, 5, 1};
        grid[2] = new int[]{4, 2, 1};
        System.out.println(minPathSum(grid));
    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] array = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0)
                        array[0][0] = grid[0][0];
                    else if (i > 0)
                        array[i][0] = array[i - 1][0] + grid[i][0];
                    else if (j > 0)
                        array[0][j] = array[0][j - 1] + grid[0][j];
                } else
                    array[i][j] = grid[i][j] + Math.min(array[i - 1][j], array[i][j - 1]);
            }
        }
        return array[m - 1][n - 1];
    }
}
