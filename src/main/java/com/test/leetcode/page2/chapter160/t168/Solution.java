package com.test.leetcode.page2.chapter160.t168;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-10 19:50
 */
public class Solution {

    String[] array = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        long number = 1L;
        while (columnNumber >= number) {
            number *= 26;
        }
        while (columnNumber > 0) {
            number = number / 26;
            long i = columnNumber / number;
            stringBuilder.append(array[((int) i) - 1]);
            columnNumber -= number * i;
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        System.out.println(convertToTitle(701));
    }
}
