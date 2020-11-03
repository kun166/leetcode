package com.test.leetcode.chapter10.t14;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-19 17:51
 */
public class Solution20201019 {

    @Test
    public void test() {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        StringBuilder result = new StringBuilder();
        char c;
        int length = 0;
        while (true) {
            c = ' ';
            for (String s : strs) {
                if (length >= s.length())
                    return result.toString();
                if (c == ' ') c = s.charAt(length);
                else if (c != s.charAt(length)) return result.toString();
            }
            result.append(c);
            length++;
        }
    }
}
