package com.test.leetcode.page5.chapter410.t417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20230530
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/30 08:39
 * @Version: 1.0
 */
public class Solution20230530 {

    /**
     * 唉，这题，如果等高各种判断，难受，不会做
     *
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] flow = new boolean[m][n];
        // 首先初始化两个可以的点，即左下角和右上角
        flow[0][n - 1] = true;
        visit(heights, flow, n - 1, 0);
        flow[m - 1][0] = true;
        visit(heights, flow, 0, m - 1);
        // 每一行的最大值能否既可流向太平洋也可流向大西洋
        for (int i = 0; i < m; i++) {
            // 找出每一行的最大值
            int col = 0;
            for (int j = 1; j < n; j++) {
                if (heights[i][j] >= heights[i][col]) {
                    col = j;
                }
            }
            // 能否流向太平洋
            // 流向太平洋的话
            boolean flowPacific = true;


            boolean canFlow = true;
            // row左边的符合递增
            for (int j = 0; j < col; j++) {
                if (heights[i][j] > heights[i][j + 1]) {
                    canFlow = false;
                    break;
                }
            }
            if (!canFlow) {
                continue;
            }
            // row右边的符合递减
            for (int j = col + 1; j < n; j++) {
                if (heights[i][j] > heights[i][j - 1]) {
                    canFlow = false;
                    break;
                }
            }
            if (canFlow) {
                flow[i][col] = true;
                visit(heights, flow, col, i);
            }

        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flow[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    /**
     * 向四个方位寻找可以的点
     *
     * @param heights
     * @param flow
     * @param x
     * @param y
     */
    public void visit(int[][] heights, boolean[][] flow, int x, int y) {
        // 向上
        if (y > 0 && !flow[y - 1][x] && heights[y - 1][x] >= heights[y][x]) {
            flow[y - 1][x] = true;
            visit(heights, flow, x, y - 1);
        }
        // 向下
        if (y < heights.length - 1 && !flow[y + 1][x] && heights[y + 1][x] >= heights[y][x]) {
            flow[y + 1][x] = true;
            visit(heights, flow, x, y + 1);
        }
        // 向左
        if (x > 0 && !flow[y][x - 1] && heights[y][x - 1] >= heights[y][x]) {
            flow[y][x - 1] = true;
            visit(heights, flow, x - 1, y);
        }
        // 向右
        if (x < heights[0].length - 1 && !flow[y][x + 1] && heights[y][x + 1] >= heights[y][x]) {
            flow[y][x + 1] = true;
            visit(heights, flow, x + 1, y);
        }
    }
}
