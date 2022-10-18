package com.test.leetcode.page1.chapter40.t44;

import org.junit.Test;

/**
 * @ClassName: Solution20221013
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/13 19:23
 * @Version: 1.0
 */
public class Solution20221013 {

    @Test
    public void test() {
        System.out.println(isMatch("aa", "a"));
    }

    public boolean isMatch(String s, String p) {
        //  dp[i][j]表示s的前i个字符和p的前j个字符的匹配情况
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // s和p都没有字符的时候，true
        dp[0][0] = true;
        // 注意: i,j均为字符串长度，不是下标
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                // 除了dp[0][0]，其它dp[i][0]都是false
                if (p.charAt(j - 1) == '*') {
                    // *匹配0-n个任意字符
                    // 匹配0个字符
                    dp[i][j] = dp[i][j - 1];

                    if (i > 0) {
                        // 匹配一个字符。
                        dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                        // 匹配多个字符
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (isMatch(s, p, i, j)) {
                    // 这里有一个隐藏的条件，即i>0，因为i=0就返回false，进不了这个分支了
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatch(String s, String p, int sp, int pp) {
        if (sp == 0) {
            // 因为此时p.charAt(pp-1)非*
            return false;
        }
        if (p.charAt(pp - 1) == '?' || s.charAt(sp - 1) == p.charAt(pp - 1)) {
            return true;
        }
        return false;
    }

}
