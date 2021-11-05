package com.test.leetcode.page1.chapter70.t72;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-10 17:34
 */
public class OfficialSolution {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组。
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        // d[i][j]表示word1前i个字符和word2前j个字符，最小变化次数
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // word1插入一个字符
                int left = D[i - 1][j] + 1;
                // word2插入一个字符
                int down = D[i][j - 1] + 1;
                // 改变一个字符
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }
}
