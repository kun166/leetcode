package com.test.leetcode.page3.chapter200.t200;

/**
 * @ClassName: SolutionSecond20230217
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/17 09:53
 * @Version: 1.0
 */
public class SolutionSecond20230217 {


    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dp(grid, i, j, m, n);
                }
            }
        }
        return ans;
    }


    /**
     * 将坐标x,y前后左右的四个点都变成'a'
     *
     * @param grid 岛屿数组
     * @param x    当前列坐标
     * @param y    当前行坐标
     * @param m    最大行
     * @param n    最大列
     */
    public void dp(char[][] grid, int y, int x, int m, int n) {
        // 非法坐标
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }
        if (grid[y][x] == '1') {
            grid[y][x] = 'a';
            dp(grid, y - 1, x, m, n);
            dp(grid, y + 1, x, m, n);
            dp(grid, y, x - 1, m, n);
            dp(grid, y, x + 1, m, n);
        }
    }
}
