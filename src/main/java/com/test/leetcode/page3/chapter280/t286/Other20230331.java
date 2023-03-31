package com.test.leetcode.page3.chapter280.t286;

/**
 * @ClassName: Other20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 15:42
 * @Version: 1.0
 */
public class Other20230331 {

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) { // start from door
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int depth) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) {
            return;
        }
        // 排除第一个点
        if (depth != 0 &&
                (
                        // rooms[i][j] == -1 // skip wall
                        // || rooms[i][j] == 0 // skip door
                        // || rooms[i][j] <= depth // skip other accessed minimum depth
                        // 鉴于depth > 0, 总和为一个条件即可
                        rooms[i][j] <= depth
                )) {
            return;
        }
        rooms[i][j] = depth;
        dfs(rooms, i, j + 1, depth + 1);
        dfs(rooms, i + 1, j, depth + 1);
        dfs(rooms, i, j - 1, depth + 1);
        dfs(rooms, i - 1, j, depth + 1);
    }
}
