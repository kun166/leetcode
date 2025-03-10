package com.test.leetcode.page1.chapter90.t97;

/**
 * @ClassName: Solution2025031001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/10 10:22
 * @Version: 1.0
 */
public class Solution2025031001 {

    /**
     * 先来个简单点的吧
     * 4ms 击败31.00%
     * 41.04MB 击败31.92%
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        // dp[i][j]标识s1的前i个字符和s2的前j个字符，和s3匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // 要么s1匹配,要么s2匹配
                dp[i][j] = dp[i][j] || i > 0 && dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                dp[i][j] = dp[i][j] || j > 0 && dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);

            }
        }
        return dp[m][n];
    }
}
