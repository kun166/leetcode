package com.test.leetcode.page1.chapter90.t96;

import org.junit.Test;

/**
 * @ClassName: Solution2025031002
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/10 09:18
 * @Version: 1.0
 */
public class Solution2025031002 {

    @Test
    public void test() {
        System.out.println(numTrees(2));
    }

    /**
     * 0ms 击败100.00%
     * 39.47MB 击败73.73%
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 1)
            return 1;
        // dp[i][j] 从i到j有多少种生成方式
        int[][] dp = new int[n + 1][n + 1];

        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i >= 1; i--) {
                for (int l = i; l <= j; l++) {
                    dp[i][j] += (l - 1 > i ? dp[i][l - 1] : 1) * (l + 1 < j ? dp[l + 1][j] : 1);
                }
            }
        }
        return dp[1][n];
    }
}
