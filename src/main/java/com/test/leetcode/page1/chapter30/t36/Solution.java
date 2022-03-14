package com.test.leetcode.page1.chapter30.t36;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-27 19:22
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // list存放的二维坐标
        Map<Character, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                List<int[]> list = map.get(c);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(c, list);
                } else {
                    for (int[] a : list) {
                        if (a[0] == i || a[1] == j || (a[0] / 3 == i / 3 && a[1] / 3 == j / 3))
                            return false;
                    }
                }
                list.add(new int[]{i, j});
            }
        }
        return true;
    }
}
