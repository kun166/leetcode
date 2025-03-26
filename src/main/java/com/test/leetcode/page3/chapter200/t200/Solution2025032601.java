package com.test.leetcode.page3.chapter200.t200;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 10:12
 * @Version: 1.0
 */
public class Solution2025032601 {

    /**
     * 这题借助一下原数组吧,先看看执行时间
     * <p>
     * 4ms	击败36.33%
     * 48.80MB	击败11.85%
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    backtrack(grid, i, j);
                }
            }
        }
        // 恢复一下
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '2') {
                    grid[i][j] = '1';
                }
            }
        }
        return ans;
    }

    /**
     * 四方搜寻,不能只左右和下,比如:
     * '1','1','1','1','1'
     * '0','0','1','0','0'
     * '1','0','1','0','0'
     * '1','0','1','0','0'
     * '1','1','1','0','0'
     *
     * @param grid
     * @param row
     * @param column
     */
    public void backtrack(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            // 越界了,退出
            return;
        }
        if (grid[row][column] != '1') {
            // 访问过或者是水
            return;
        }
        grid[row][column] = '2';
        backtrack(grid, row - 1, column);
        backtrack(grid, row + 1, column);
        backtrack(grid, row, column - 1);
        backtrack(grid, row, column + 1);
    }
}
