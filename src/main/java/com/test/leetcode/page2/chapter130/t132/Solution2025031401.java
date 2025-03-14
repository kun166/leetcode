package com.test.leetcode.page2.chapter130.t132;

import java.util.Arrays;

/**
 * @ClassName: Solution2025031401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/14 16:43
 * @Version: 1.0
 */
public class Solution2025031401 {

    /**
     * 这题还是要DP啊……
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        int n = s.length();
        /**
         * dp[i][j]标识下标从i到j是回文字符串
         */
        boolean[][] dp = new boolean[n][n];
        /**
         * dp1[i]标识下标为i的字符到结尾,最小的分割次数
         */
        int[] dp1 = new int[n + 1];

        Arrays.fill(dp1, Integer.MAX_VALUE);
        // n的时候,不需要切割就是回文串
        dp1[n] = -1;
        // 计算回文字符串dp
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (j >= i + 2 ? dp[i + 1][j - 1] : true) && s.charAt(i) == s.charAt(j);
            }
        }
        // 计算最小切割次数dp1
        for (int i = n - 1; i >= 0; i--) {
            // 当前下标到结尾的距离
            int length = n - i;
            for (int j = 1; j <= length; j++) {
                if (dp[i][i + j - 1])
                    dp1[i] = Math.min(dp1[i], dp1[i + j] + 1);
            }
        }
        return dp1[0];

    }

//    public int minCut(String s, int left, int right, boolean[][] dp) {
//        if (dp[left][right])
//            return 0;
//
//    }
}
