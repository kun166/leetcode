package com.test.leetcode.page2.chapter150.t151;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-04 14:49
 */
public class Solution {

    @Test
    public void test() {
        System.out.println("--" + reverseWords("  hello world  ") + "--");
    }

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int end = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (i + 1 != end) {
                    stringBuilder.append(s.substring(i + 1, end)).append(' ');
                }
                end = i;
            }
        }
        if (end != 0) {
            stringBuilder.append(s.substring(0, end)).append(' ');
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }
}
