package com.test.leetcode.page1.chapter10.t10;

import org.junit.Test;

/**
 * @ClassName: Solution20250210
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/10 17:52
 * @Version: 1.0
 */
public class Solution20250210 {


    @Test
    public void test() {
        System.out.println(isMatch("aab", "c*a*b"));
    }

    /**
     * 这个用DP吧
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        // 起始dp[0][0] = true;
        dp[0][0] = true;
        for (int j = 2; j <= pl; j++) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        // dp[m][n]
        for (int j = 1; j <= pl; j++) {
            for (int i = 1; i <= sl; i++) {
                // p.charAt(j)只有三种情况,".","*"或者是普通字符
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // 匹配0个字符,本来还有一个j>=2,但是题目说明中已经暗含j>=2了，这个地方不再判断
                    dp[i][j] = dp[i][j - 2];
                    // 匹配一个字符,对比p.charAt[j-2]
                    dp[i][j] = dp[i][j] || (dp[i - 1][j - 2] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'));
                    // 匹配多个字符
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'));
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && p.charAt(j - 1) == s.charAt(i - 1);
                }
            }
        }
        return dp[sl][pl];
    }
}
