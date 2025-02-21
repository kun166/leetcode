package com.test.leetcode.page1.chapter0.t5;

/**
 * @ClassName: Solution20250208
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/8 10:57
 * @Version: 1.0
 */
public class Solution2025020802 {

    /**
     * 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int m = s.length();
        /**
         * dp[m][n],标识从m到n是否是回文字符串
         * dp[m][n] = dp[m+1][n-1]&&char[m] == char[n]
         */
        boolean[][] dp = new boolean[m][m];
        // 最长回文字符串的起始和结束位置
        int start = 0, end = 0;
        for (int i = 1; i <= m; i++) {
            // 字符串长度,从1到m
            for (int j = m - 1; j >= 0; j--) {
                // 从字符串尾部开始,因为dp[m][n]n比m大
                if (i == 1) {
                    dp[j][j] = true;
                } else if (i == 2) {
                    if (j + 1 < m) {
                        dp[j][j + 1] = s.charAt(j) == s.charAt(j + 1);
                        if (dp[j][j + 1] && 2 > end - start) {
                            start = j;
                            end = j + 1;
                        }
                    }
                } else {
                    // 不关心长度是奇数还是偶数
                    if (j + 1 < m && j + i - 1 < m) {
                        dp[j][j + i - 1] = dp[j + 1][j + i - 2] && s.charAt(j) == s.charAt(j + i - 1);
                        if (dp[j][j + i - 1] && i > end - start) {
                            start = j;
                            end = j + i - 1;
                        }
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
