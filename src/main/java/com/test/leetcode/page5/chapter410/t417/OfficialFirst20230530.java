package com.test.leetcode.page5.chapter410.t417;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230530
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/30 09:45
 * @Version: 1.0
 */
public class OfficialFirst20230530 {

    // 定义四个方向
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 保存传参
    int[][] heights;
    // 二位数组行，列
    int m, n;

    /**
     * 唉，分别处理两个洋，这样就把问题给分解的特别的简单了
     *
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 保存传参
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        // 能通向太平洋
        boolean[][] pacific = new boolean[m][n];
        // 能通向大西洋
        boolean[][] atlantic = new boolean[m][n];
        // 太平洋遍历上边和左边
        // 遍历左边
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        // 遍历上边
        for (int j = 1; j < n; j++) {
            dfs(0, j, pacific);
        }
        // 大西洋遍历右边和下边
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n - 1; j++) {
            dfs(m - 1, j, atlantic);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    public void dfs(int row, int col, boolean[][] ocean) {
        // 说明这个点已经遍历过了
        if (ocean[row][col]) {
            return;
        }
        // 设置能过
        ocean[row][col] = true;
        // 向四个方向延伸
        for (int[] dir : dirs) {
            // 新的行，新的列
            int newRow = row + dir[0], newCol = col + dir[1];
            // 新的点不能超出边界，且新的点位置不比当前点低
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, ocean);
            }
        }
    }
}
