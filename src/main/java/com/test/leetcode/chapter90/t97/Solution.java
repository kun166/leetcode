package com.test.leetcode.chapter90.t97;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-10 15:06
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        // dq[i][j]表示s1的前i个字符和s2的前j个字符，是否和s3的前i+j个字符匹配
        boolean[][] dq = new boolean[s1.length() + 1][s2.length() + 1];
        dq[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    dq[i][j] = dq[i][j - 1];
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    dq[i][j] = dq[i][j] || dq[i - 1][j];
            }
        }
        return dq[s1.length()][s2.length()];
    }
}
