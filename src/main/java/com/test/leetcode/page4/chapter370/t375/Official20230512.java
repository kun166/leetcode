package com.test.leetcode.page4.chapter370.t375;

/**
 * @ClassName: Official20230512
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/12 15:04
 * @Version: 1.0
 */
public class Official20230512 {

    public int getMoneyAmount(int n) {
        // 如果i==j,则f[i][j]=0
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }
}
