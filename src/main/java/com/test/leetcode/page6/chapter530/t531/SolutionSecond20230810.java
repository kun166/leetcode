package com.test.leetcode.page6.chapter530.t531;

/**
 * @ClassName: SolutionSecond20230810
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/10 16:12
 * @Version: 1.0
 */
public class SolutionSecond20230810 {


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：44.1 MB, 在所有 Java 提交中击败了40.87%的用户
     * 通过测试用例：52 / 52
     *
     * @param picture
     * @return
     */
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (row[i] == 1) {
                for (int j = 0; j < n; j++) {
                    if (picture[i][j] == 'B' && col[j] == 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
