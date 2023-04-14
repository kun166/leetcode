package com.test.leetcode.page4.chapter310.t311;

/**
 * @ClassName: Solution20230414
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/14 09:39
 * @Version: 1.0
 */
public class Solution20230414 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, k = mat1[0].length, n = mat2[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < k; l++) {
                    ans[i][j] += mat1[i][l] * mat2[l][j];
                }
            }
        }
        return ans;
    }
}
