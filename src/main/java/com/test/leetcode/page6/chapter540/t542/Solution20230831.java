package com.test.leetcode.page6.chapter540.t542;

/**
 * @ClassName: Solution20230831
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/31 09:02
 * @Version: 1.0
 */
public class Solution20230831 {

    /**
     * 1304ms
     * 击败 5.02%使用 Java 的用户
     * 44.10MB
     * 击败 24.21%使用 Java 的用户
     *
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // 先把1的位置设置为-1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }
        // 碰到0就去更改距离
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    updateMatrix(mat, j, i, 0);
                }
            }
        }
        return mat;
    }

    public void updateMatrix(int[][] mat, int x, int y, int distance) {
        if (x < 0 || x >= mat[0].length || y < 0 || y >= mat.length) {
            // 越界了，返回
            return;
        }
        if (mat[y][x] == -1) {
            mat[y][x] = distance;
        } else if (distance > 0 && distance >= mat[y][x]) {
            // 当前
            return;
        }
        mat[y][x] = distance;
        // 向四个方向发展
        updateMatrix(mat, x + 1, y, distance + 1);
        updateMatrix(mat, x - 1, y, distance + 1);
        updateMatrix(mat, x, y + 1, distance + 1);
        updateMatrix(mat, x, y - 1, distance + 1);
    }
}
