package com.test.leetcode.page3.chapter280.t286;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: OfficialSecond20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 15:39
 * @Version: 1.0
 */
public class OfficialSecond20230331 {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了48.11%的用户
     * 内存消耗：45 MB, 在所有 Java 提交中击败了58.38%的用户
     * 通过测试用例：62 / 62
     *
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[]{row, col});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[]{r, c});
            }
        }
    }
}
