package com.test.leetcode.page1.chapter60.t63;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-09 11:09
 */
public class Solution {

    @Test
    public void test() {
        int[][] obstacleGrid = new int[3][3];
        obstacleGrid[0] = new int[]{0, 0, 0};
        obstacleGrid[1] = new int[]{0, 1, 0};
        obstacleGrid[2] = new int[]{0, 0, 0};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] array = new int[m][n];
        array[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                array[i][0] = 0;
            else
                array[i][0] = array[i - 1][0];

        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1)
                array[0][j] = 0;
            else
                array[0][j] = array[0][j - 1];

        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    array[i][j] = 0;
                else
                    array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m - 1][n - 1];
    }
}
