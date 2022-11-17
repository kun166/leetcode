package com.test.leetcode.page1.chapter60.t62;

/**
 * @ClassName: Solution20221117
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/17 6:58
 * @Version: 1.0
 */
public class Solution20221117 {

    /**
     * 这应该是算是最简单的动态规划题目了
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = 1;
                    continue;
                }
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
