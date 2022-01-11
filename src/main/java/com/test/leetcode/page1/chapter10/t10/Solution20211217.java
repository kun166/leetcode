package com.test.leetcode.page1.chapter10.t10;

/**
 * @ClassName: Solution20211217
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/12/17 19:37
 * @Version: 1.0
 */
public class Solution20211217 {

    /**
     * 肯定得动态规划了
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sLength = s.length(), pLength = p.length();
        // dp[i][j]标识s的前i个字符是否和p的前j个字符匹配
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        char[] sArray = s.toCharArray(), pArray = p.toCharArray();
        dp[0][0] = true;
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (sArray[i - 1] == pArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pArray[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pArray[j - 1] == '*') {
                    if (j - 1 > 0) {
                        if (pArray[j - 2] == '.') {
                            dp[i][j] = dp[i - 2][j - 2] || dp[i - 1][j - 1];
                        }
                    }
                    //dp[i][j] =
                }
            }
        }
        return false;
    }
}
