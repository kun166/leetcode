package com.test.leetcode.page1.chapter20.t28;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-17 17:06
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(strStr("bbba", "bba"));
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int hl = haystack.length();
        int nl = needle.length();
        if (nl > hl) {
            return -1;
        }
        char[] hca = haystack.toCharArray();
        char[] nca = needle.toCharArray();
        int nIndex;
        for (int i = 0; i < hl - nl + 1; i++) {
            if (hca[i] == nca[0]) {
                for (nIndex = 0; nIndex < nl; nIndex++) {
                    if (hca[i + nIndex] != nca[nIndex]) break;
                }
                if (nIndex == nl) return i;
            }
        }
        return -1;
    }
}
