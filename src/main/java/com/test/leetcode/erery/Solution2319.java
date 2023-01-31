package com.test.leetcode.erery;

/**
 * @ClassName: Solution2319
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/31 08:22
 * @Version: 1.0
 */
public class Solution2319 {

    /**
     * 这个简单题居然翻车
     *
     * @param grid
     * @return
     */
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i == j) || (i + j == n - 1))) {
                    // 下面的if，不能提到上面来，不能提到上面来
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
