package com.test.leetcode.page3.chapter200.t200;

/**
 * @ClassName: Solution20230217
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/17 09:36
 * @Version: 1.0
 */
public class SolutionFirst20230217 {

    /**
     * 一种比较容易理解的方式：
     * 从左上角开始遍历二维数组，如果当前方格是'1',
     * 1,它上方和左方是否有'1',有则说明是连成块的，继续访问
     * 2,它上方和左方都不为'1',则岛屿数量+1
     * <p>
     * 呃，好吧，这是个错误的示范
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = grid[0][0] == '1' ? 1 : 0;
        // 对m=0和n=0单独处理
        // 先对行进行处理
        for (int i = 1; i < m; i++) {
            if (grid[i][0] == '1' && grid[i - 1][0] == '0') {
                ans++;
            }
        }
        // 对列进行处理
        for (int i = 1; i < n; i++) {
            if (grid[0][i] == '1' && grid[0][i - 1] == '0') {
                ans++;
            }
        }
        // 对剩余的进行处理
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == '1' && grid[i - 1][j] == '0' && grid[i][j - 1] == '0') {
                    ans++;
                }
            }
        }
        return ans;
    }
}
