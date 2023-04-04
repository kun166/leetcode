package com.test.leetcode.page4.chapter300.t302;

/**
 * @ClassName: Solution20230404
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/4 17:34
 * @Version: 1.0
 */
public class Solution20230404 {

    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = n, right = 0, down = 0, up = m;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == '1') {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    down = Math.max(down, i);
                    up = Math.min(up, i);
                }
            }
        }
        return (right - left + 1) * (down - up + 1);
    }
}
