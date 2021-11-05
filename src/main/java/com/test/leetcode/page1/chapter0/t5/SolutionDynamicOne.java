package com.test.leetcode.page1.chapter0.t5;

import org.junit.Test;

/**
 * 回文子规律：
 * 1，一个字符的时候，是回文子；
 * 2，连续的两个字符，且相等时，是回文子
 * 3，如果一个字符串是回文子，且该字符串前后两个字符如果相等，则该字符串加上它前后的两个字符同样是回文子
 *
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-11 13:59
 */
public class SolutionDynamicOne {

    @Test
    public void test() {
        String s = "abcabcbadd";
        System.out.println(longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        int max = 0, start = 0, end = 0;
        boolean[][] dp = new boolean[length][length];

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (i == j) dp[i][j] = true;
                else if (j == i + 1 && array[i] == array[j]) dp[i][j] = true;
                else if (i != length - 1) dp[i][j] = dp[i + 1][j - 1] && array[i] == array[j];

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
