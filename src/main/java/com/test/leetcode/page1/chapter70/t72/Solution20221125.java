package com.test.leetcode.page1.chapter70.t72;

import org.junit.Test;

/**
 * @ClassName: Solution20221125
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/25 10:40
 * @Version: 1.0
 */
public class Solution20221125 {

    @Test
    public void test() {
        System.out.println(minDistance("intention", "execution"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 插入word1
                int insertWord1Count = dp[i - 1][j] + 1;
                // 插入word2
                int insertWord2Count = dp[i][j - 1] + 1;
                // 修改一个字符
                int fixCount = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                dp[i][j] = Math.min(Math.min(insertWord1Count, insertWord2Count), fixCount);
            }
        }
        return dp[m][n];
    }
}
