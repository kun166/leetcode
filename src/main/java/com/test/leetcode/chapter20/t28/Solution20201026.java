package com.test.leetcode.chapter20.t28;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-26 17:15
 */
public class Solution20201026 {

    @Test
    public void test() {
        System.out.println(strStr("hello", "ll"));
    }

    public int strStr(String haystack, String needle) {
        int nL = needle.length(), hL = haystack.length();
        if (nL == 0)
            return 0;
        if (nL > hL)
            return -1;
        hL -= nL;
        for (int i = 0; i <= hL; i++) {
            int k = nL - 1;
            while (k >= 0) {
                if (needle.charAt(k) != haystack.charAt(i + k))
                    break;
                k--;
            }
            if (k == -1)
                return i;

        }
        return -1;
    }
}
