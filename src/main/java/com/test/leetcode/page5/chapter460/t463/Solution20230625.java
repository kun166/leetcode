package com.test.leetcode.page5.chapter460.t463;

/**
 * @ClassName: Solution20230625
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/25 08:43
 * @Version: 1.0
 */
public class Solution20230625 {

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了99.73%的用户
     * 内存消耗：43.1 MB, 在所有 Java 提交中击败了15.58%的用户
     * 通过测试用例：5833 / 5833
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前位置不是陆地，则寻找陆地
                if (grid[i][j] == 0) {
                    continue;
                }
                // 上下左右四个边
                // 上
                if (i == 0 || grid[i - 1][j] == 0) {
                    ans++;
                }
                // 下
                if (i == m - 1 || grid[i + 1][j] == 0) {
                    ans++;
                }
                // 左
                if (j == 0 || grid[i][j - 1] == 0) {
                    ans++;
                }
                // 右
                if (j == n - 1 || grid[i][j + 1] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
