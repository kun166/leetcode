package com.test.leetcode.page1.chapter0.t5;

import org.junit.Test;

/**
 * @ClassName: Solution20220622
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/22 10:35
 * @Version: 1.0
 */
public class Solution20220622 {

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // 在每一个字符上检查回文子
            // 第一种情况，当前字符与上一个字符一样
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                int length = 1;
                while (i - 1 - length > -1 && i + length < s.length() && s.charAt(i - 1 - length) == s.charAt(i + length)) {
                    length++;
                }
                if (length * 2 > max) {
                    max = length * 2;
                    left = i - length;
                    right = i - 1 + length;
                }
            }
            // 第二种情况，当前字符与上一个字符不一样
            int length = 1;
            while (i - length > -1 && i + length < s.length() && s.charAt(i - length) == s.charAt(i + length)) {
                length++;
            }
            if (2 * length - 1 > max) {
                max = 2 * length - 1;
                left = i + 1 - length;
                right = i - 1 + length;
            }
        }
        return s.substring(left, right + 1);
    }
}
