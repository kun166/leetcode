package com.test.leetcode.page3.chapter290.t296;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230404
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/4 10:31
 * @Version: 1.0
 */
public class Solution20230404 {


    /**
     * 超出时间限制……
     *
     * @param grid
     * @return
     */
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    list.add(i * 200 + j);
                }
            }
        }
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance = Math.min(distance, getDistance(i, j, list));
            }
        }
        return distance;
    }

    public int getDistance(int y, int x, List<Integer> list) {
        int distance = 0;
        for (int num : list) {
            distance += (Math.abs(y - num / 200) + Math.abs(x - num % 200));
        }
        return distance;
    }

}
