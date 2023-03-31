package com.test.leetcode.page3.chapter280.t286;

import org.junit.Test;

/**
 * @ClassName: Solution20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 14:38
 * @Version: 1.0
 */
public class Solution20230331 {

    @Test
    public void test() {
        int[][] rooms = new int[][]{{2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};
        wallsAndGates(rooms);
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了98.92%的用户
     * 内存消耗：45.2 MB, 在所有 Java 提交中击败了35.68%的用户
     * 通过测试用例：62 / 62
     *
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    // 这个地方还想着申请一个新的boolean[][]记录是否扫描过呢……
                    wallsAndGates(rooms, i, j, 0);
                }
            }
        }
    }

    public void wallsAndGates(int[][] rooms, int y, int x, int distance) {
        if (y < 0 || y >= rooms.length || x < 0 || x >= rooms[0].length || rooms[y][x] == -1) {
            // 越界了
            return;
        }
        // 第一版，没加条件，向四周扩散，死循环……
        // 第二版加了if (distance <= rooms[y][x]),向四周扩散，超时
        // 第三版，就是现在这版，还挺爽的
        if (distance == 0) {
            wallsAndGates(rooms, y - 1, x, distance + 1);
            wallsAndGates(rooms, y + 1, x, distance + 1);
            wallsAndGates(rooms, y, x - 1, distance + 1);
            wallsAndGates(rooms, y, x + 1, distance + 1);
        } else {
            if (distance < rooms[y][x]) {
                rooms[y][x] = distance;
                wallsAndGates(rooms, y - 1, x, distance + 1);
                wallsAndGates(rooms, y + 1, x, distance + 1);
                wallsAndGates(rooms, y, x - 1, distance + 1);
                wallsAndGates(rooms, y, x + 1, distance + 1);
            }
        }

    }
}
