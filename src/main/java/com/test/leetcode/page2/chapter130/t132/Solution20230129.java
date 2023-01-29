package com.test.leetcode.page2.chapter130.t132;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution20230129
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/29 14:31
 * @Version: 1.0
 */
public class Solution20230129 {

    @Test
    public void test() {
        System.out.println(minCut("aab"));
    }

    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        // 又是一个dp
        int[] c = new int[n];
        Arrays.fill(c, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                c[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        c[i] = Math.min(c[i], c[j] + 1);
                    }
                }
            }
        }
        return c[n - 1];
    }
}
