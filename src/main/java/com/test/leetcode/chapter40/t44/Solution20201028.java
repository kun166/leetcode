package com.test.leetcode.chapter40.t44;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-28 16:36
 */
public class Solution20201028 {

    @Test
    public void test() {
        System.out.println(isMatch("acdcb", "a*c?b"));
    }

    public boolean isMatch(String s, String p) {
        int sL = s.length(), pL = p.length();
        // f[m][n]标识s的前m个字符，和p的前n个字符的匹配情况
        boolean[][] f = new boolean[sL + 1][pL + 1];
        f[0][0] = true;
        for (int i = 0; i <= sL; i++) {
            for (int j = 1; j <= pL; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 第一种情况，一个也不需要匹配
                    f[i][j] = f[i][j - 1];
                    if (i != 0) {
                        // 第二种情况，需要匹配一次
                        f[i][j] = f[i][j] || f[i - 1][j - 1];
                        // 第三种情况，匹配多次
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }

                } else {
                    if (isMatch(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[sL][pL];
    }

    /**
     * 字符串s的第m个字符，和p的第n个字符的匹配情况
     *
     * @param s
     * @param p
     * @param m
     * @param n
     * @return
     */
    public boolean isMatch(String s, String p, int m, int n) {
        if (m == 0 || n == 0) {
            return false;
        }
        if (p.charAt(n - 1) == '?')
            return true;
        return s.charAt(m - 1) == p.charAt(n - 1);
    }
}
