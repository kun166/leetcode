package com.test.leetcode.page4.chapter300.t305;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Other20230408
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/8 8:21
 * @Version: 1.0
 */
public class Other20230408 {

    int[] pas;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        pas = new int[m * n];

        // 每一个坐标的父节点都设置为自己
        for (int i = 0; i < pas.length; i++) {
            pas[i] = i;
        }
        int[] grid = new int[m * n];
        int count = 0;
        for (int[] position : positions) {
            int row = position[0];
            int column = position[1];
            int c = row * n + column;
            if (grid[c] != 1) {
                grid[c] = 1;
                count++;
            }
            if (row > 0 && grid[c - n] == 1 && union(c, c - n)) count--;
            if (row < m - 1 && grid[c + n] == 1 && union(c, c + n)) count--;
            if (column > 0 && grid[c - 1] == 1 && union(c, c - 1)) count--;
            if (column < n - 1 && grid[c + 1] == 1 && union(c, c + 1)) count--;
            ans.add(count);
        }
        return ans;
    }

    private boolean union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) return false;
        pas[rx] = ry;
        return true;
    }

    private int find(int x) {
        while (x != pas[x]) {
            pas[x] = pas[pas[x]];
            x = pas[x];
        }
        return x;
    }
}
