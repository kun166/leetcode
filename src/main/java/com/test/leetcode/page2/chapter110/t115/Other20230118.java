package com.test.leetcode.page2.chapter110.t115;

/**
 * @ClassName: Other20230118
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/18 9:08
 * @Version: 1.0
 */
public class Other20230118 {

    /**
     * 这是其他大神的解法思路。从这里看，关于字符串的匹配，从前向后可以，从后向前也可以啊
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++)
            dp[0][j] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[n][m];
    }
}
