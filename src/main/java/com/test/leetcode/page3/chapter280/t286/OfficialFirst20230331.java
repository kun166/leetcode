package com.test.leetcode.page3.chapter280.t286;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: OfficialFirst20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 15:36
 * @Version: 1.0
 */
public class OfficialFirst20230331 {

    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    /**
     * 执行用时：1097 ms, 在所有 Java 提交中击败了5.41%的用户
     * 内存消耗：44.9 MB, 在所有 Java 提交中击败了64.87%的用户
     * 通过测试用例：62 / 62
     *
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[0].length; col++) {
                if (rooms[row][col] == EMPTY) {
                    rooms[row][col] = distanceToNearestGate(rooms, row, col);
                }
            }
        }
    }

    private int distanceToNearestGate(int[][] rooms, int startRow, int startCol) {
        int m = rooms.length;
        int n = rooms[0].length;
        int[][] distance = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startRow, startCol});
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] == WALL
                        || distance[r][c] != 0) {
                    continue;
                }
                distance[r][c] = distance[row][col] + 1;
                if (rooms[r][c] == GATE) {
                    return distance[r][c];
                }
                q.add(new int[]{r, c});
            }
        }
        return Integer.MAX_VALUE;
    }
}
