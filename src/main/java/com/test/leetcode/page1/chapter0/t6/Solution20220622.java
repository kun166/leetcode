package com.test.leetcode.page1.chapter0.t6;

import org.junit.Test;

/**
 * @ClassName: Solution20220622
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/22 16:30
 * @Version: 1.0
 */
public class Solution20220622 {

    @Test
    public void test() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        boolean forward = true;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            if (forward) {
                builders[row++].append(s.charAt(i));
            } else {
                builders[row--].append(s.charAt(i));
            }
            if (i == 0 || i == numRows - 1) {
                forward = !forward;
            }
        }
        for (int i = 1; i < numRows; i++) {
            builders[0].append(builders[i]);
        }
        return builders[0].toString();
    }
}
