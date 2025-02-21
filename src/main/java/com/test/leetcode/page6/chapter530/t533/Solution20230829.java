package com.test.leetcode.page6.chapter530.t533;

/**
 * @ClassName: Solution20230829
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/29 08:59
 * @Version: 1.0
 */
public class Solution20230829 {

    public int findBlackPixel(char[][] picture, int target) {
        int m = picture.length, n = picture[0].length;
        boolean[] row = new boolean[m];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    count++;
                }
            }
            if (count == target) {
                row[i] = true;
            }
        }
        boolean[] col = new boolean[n];
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (picture[i][j] == 'B') {
                    count++;
                }
            }
            if (count == target) {
                col[j] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && row[i] && col[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
