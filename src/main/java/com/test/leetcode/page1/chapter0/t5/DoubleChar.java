package com.test.leetcode.page1.chapter0.t5;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-10 19:06
 */
public class DoubleChar {

    @Test
    public void test() {
        String s = "abcdd";
        int length = s.length();
        int start = 0, end = 0, max = 0;
        for (int i = 0; i < length; i++) {
            int[] array = getDoubleChar(s, i, i);
            if (array[1] - array[0] + 1 > max) {
                max = array[1] - array[0] + 1;
                start = array[0];
                end = array[1];
            }
        }
        System.out.println(s.substring(start, end + 1));
    }

    public int[] getDoubleChar(String s, int start, int end) {
        if (start == 0 || end == s.length() - 1) {
            int[] array = {start, end};
            return array;
        }
        if (s.charAt(start - 1) == s.charAt(end + 1)) {
            return getDoubleChar(s, start - 1, end + 1);
        } else {
            int[] array = {start, end};
            return array;
        }
    }
}
