package com.test.leetcode.page1.chapter20.t28;

import org.junit.Test;

/**
 * @ClassName: KMP20221025
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/25 09:26
 * @Version: 1.0
 */
public class KMP20221025 {

    @Test
    public void test() {
        System.out.println(strStr("sadbutsad", "sad"));
    }


    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n == 0) {
            return 0;
        }
        // 先求needle的pmt
        int[] pmt = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pmt[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pmt[i] = j;
        }
        // 开始用kmp方法求值
        for (int i = 0, j = 0; i < m; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pmt[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == n) {
                return i - n + 1;
            }
        }
        return -1;
    }
}
