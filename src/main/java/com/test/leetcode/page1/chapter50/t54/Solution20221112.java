package com.test.leetcode.page1.chapter50.t54;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20221112
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/12 17:44
 * @Version: 1.0
 */
public class Solution20221112 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, total = m * n;
        // x行,y列
        int type = 0, x = 0, y = 0, cycle = 1;
        List<Integer> list = new ArrayList<>();
        while (list.size() != total) {
            list.add(matrix[x][y]);
            if (type == 0) {
                if (y == n - cycle) {
                    //需要转向了
                    type = 1;
                    x++;
                } else {
                    y++;
                }
            } else if (type == 1) {
                if (x == m - cycle) {
                    type = 2;
                    y--;
                } else {
                    x++;
                }
            } else if (type == 2) {
                if (y == cycle - 1) {
                    type = 3;
                    x--;
                } else {
                    y--;
                }
            } else if (type == 3) {
                if (x == cycle) {
                    type = 0;
                    cycle++;
                    y++;
                } else {
                    x--;
                }
            }
        }
        return list;
    }
}
