package com.test.leetcode.page2.chapter130.t132;

import org.junit.Test;

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
        System.out.println(minCut("aaabaa"));
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
        int lc = 0;
        int start = 0, end = n - 1;
        // 从左向右
        while (start <= end) {
            if (dp[start][end]) {
                if (end == n - 1) {
                    break;
                } else {
                    lc++;
                    start = end + 1;
                    end = n - 1;
                }
            } else {
                end--;
            }
        }
        // 从右向左
        int rc = 0;
        start = 0;
        end = n - 1;
        while (start <= end) {
            if (dp[start][end]) {
                if (start == 0) {
                    break;
                } else {
                    rc++;
                    end = start - 1;
                    start = 0;
                }
            } else {
                start++;
            }
        }
        return Math.min(lc, rc);
    }
}
