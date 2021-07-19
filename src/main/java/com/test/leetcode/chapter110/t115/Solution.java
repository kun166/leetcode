package com.test.leetcode.chapter110.t115;

/**
 * 判断字符串t在字符串s中出现的次数
 *
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-05-21 10:10
 */
public class Solution {

    public int numDistinct(String s, String t) {
        // 取字符串s和t的长度
        int m = s.length(), n = t.length();
        // 如果字符串s的长度小于t，则肯定是0次
        if (m < n) {
            return 0;
        }
        // 构造m+1,n+1的二维数组
        // dp[x][y]标示t的第y个字符之后的字符在s的第x字符及之后的字符的匹配次数
        int[][] dp = new int[m + 1][n + 1];
        // dp[i][n]，因为n是空字符串，所有都匹配
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    // 匹配次数等于 去掉该字符的匹配次数加上s除去该字符之前的匹配次数
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
