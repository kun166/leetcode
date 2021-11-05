package com.test.leetcode.page1.chapter90.t91;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-04 11:00
 */
public class Solution20201204 {

    @Test
    public void test() {
        String[] array = {"12", "0", "226", "2101", "10"};
        for (String s : array) {
            System.out.println(s + ":" + numDecodings(s));
        }
    }

    public int numDecodings(String s) {
        char[] array = s.toCharArray();
        int stepOne = s.charAt(0) == '0' ? 0 : 1;
        if (array.length == 1)
            return stepOne;
        int stepTwo = s.charAt(1) == '0' ? stepOne : Integer.parseInt(s.substring(0, 2)) <= 26 ? stepOne + 1 : stepOne;
        for (int i = 2; i < array.length; i++) {
            if (array[i] == '0') {
                stepOne = stepTwo;
            } else if ((array[i - 1] - '0') * 10 + array[i] - '0' <= 26) {
                int count = stepOne + stepTwo;
                stepOne = stepTwo;
                stepTwo = count;
            }
        }
        return stepTwo;
    }
}
