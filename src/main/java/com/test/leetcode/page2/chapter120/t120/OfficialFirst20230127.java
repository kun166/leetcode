package com.test.leetcode.page2.chapter120.t120;

import java.util.List;

/**
 * @ClassName: OfficialFirst20230127
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 10:07
 * @Version: 1.0
 */
public class OfficialFirst20230127 {

    /**
     * 呃，这题居然是一个动态规划题，确实没想到啊……
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
