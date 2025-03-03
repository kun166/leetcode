package com.test.leetcode.page1.chapter40.t44;

/**
 * @ClassName: Solution2025022401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/24 16:48
 * @Version: 1.0
 */
public class Solution2025022401 {

    /**
     * 呃，只能用dp么？别的感觉不会啊
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pl; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 1,匹配0个字符;2,匹配1个字符;3,匹配多个字符
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];
                } else {
                    if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sl][pl];
    }
}
