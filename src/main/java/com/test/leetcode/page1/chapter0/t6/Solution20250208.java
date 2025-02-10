package com.test.leetcode.page1.chapter0.t6;

import org.junit.Test;

/**
 * @ClassName: Solution20250208
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/8 16:09
 * @Version: 1.0
 */
public class Solution20250208 {

    @Test
    public void test() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] array = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            array[i] = new StringBuilder();
        }
        int step = 1, line = 0;
        for (int i = 0; i < s.length(); i++) {
            array[line].append(s.charAt(i));
            line += step;
            if (line == numRows - 1 || line == 0) {
                step = -step;
            }
        }
        for (int i = 1; i < numRows; i++) {
            array[0].append(array[i]);
        }
        return array[0].toString();
    }
}
