package com.test.leetcode.page1.chapter60.t64;

/**
 * @ClassName: SolutionSecond20230705
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/5 16:48
 * @Version: 1.0
 */
public class SolutionSecond20230705 {

    int ans = Integer.MAX_VALUE;

    /**
     * 超出时间限制
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        minPathSum(grid, 0, 0, 0);
        return ans;
    }

    public void minPathSum(int[][] grid, int x, int y, int sum) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            ans = Math.min(ans, sum + grid[x][y]);
            return;
        }
        if (x < grid.length - 1) {
            minPathSum(grid, x + 1, y, sum + grid[x][y]);
        }
        if (y < grid[0].length - 1) {
            minPathSum(grid, x, y + 1, sum + grid[x][y]);
        }
    }
}
