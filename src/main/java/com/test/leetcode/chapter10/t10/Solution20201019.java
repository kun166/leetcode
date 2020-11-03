package com.test.leetcode.chapter10.t10;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-19 11:25
 */
public class Solution20201019 {

    @Test
    public void test() {
        System.out.println(isMatch("", ""));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("aa", "*a"));
        System.out.println(isMatch("aab", "c*a**b"));
    }

    public boolean isMatch(String s, String p) {
        int sL = s.length();
        int pL = p.length();
        boolean[][] f = new boolean[sL + 1][pL + 1];
        // f[i][j]标识s的前i个字符，和p的前j个字符的匹配度
        // 两个空串，匹配
        f[0][0] = true;
        for (int i = 0; i <= sL; i++) {
            for (int j = 1; j <= pL; j++) {
                if (j > 1 && p.charAt(j - 1) == '*') {
                    // 一次也不匹配和匹配一次
                    f[i][j] = f[i][j - 2];
                    if (isMatch(s, p, i, j - 1)) {
                        // 匹配一次
                        f[i][j] = f[i][j] || f[i][j - 1];
                        // 匹配多次
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
     * s的第i个字符，是否匹配p的第j个字符
     *
     * @param s
     * @param p
     * @param i
     * @param j
     * @return
     */
    public boolean isMatch(String s, String p, int i, int j) {
        if (i == 0)
            return false;
        if (p.charAt(j - 1) == '.')
            return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
