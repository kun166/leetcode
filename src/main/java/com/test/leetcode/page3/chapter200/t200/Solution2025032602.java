package com.test.leetcode.page3.chapter200.t200;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 10:12
 * @Version: 1.0
 */
public class Solution2025032602 {

    /**
     * 这题借助一下原数组吧,不恢复空间
     * <p>
     * 3ms	击败81.88%
     * 48.45MB	击败65.93%
     * <p>
     * 呃,效果还是一般啊……
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
        return ans;
    }

    public void backtrack(char[][] grid, int row, int column) {
        if (grid[row][column] != '1') {
            // 访问过或者是水
            return;
        }
        grid[row][column] = '2';
        if (row > 0) {
            backtrack(grid, row - 1, column);
        }
        if (row < grid.length - 1) {
            backtrack(grid, row + 1, column);
        }
        if (column > 0) {
            backtrack(grid, row, column - 1);
        }
        if (column < grid[0].length - 1) {
            backtrack(grid, row, column + 1);
        }
    }
}
