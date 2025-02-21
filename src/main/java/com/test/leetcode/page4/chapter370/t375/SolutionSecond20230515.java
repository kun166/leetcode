package com.test.leetcode.page4.chapter370.t375;

import org.junit.Test;

/**
 * @ClassName: Solution20230515
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/15 09:17
 * @Version: 1.0
 */
public class SolutionSecond20230515 {

    @Test
    public void test() {
        System.out.println(getMoneyAmount(10));
    }

    /**
     * @param n
     * @return
     */
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 2][n + 2];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i >= 1; i--) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }
}
