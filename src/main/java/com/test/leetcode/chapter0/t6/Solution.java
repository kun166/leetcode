package com.test.leetcode.chapter0.t6;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-11 14:29
 */
public class Solution {

    @Test
    public void test() {
        String s = "LEETCODEISHIRING";
        System.out.println(zStr(s, 2));
    }

    public String zStr(String s, int row) {
        if (row == 1) {
            return s;
        }
        int length = s.length();


        char[] array = s.toCharArray();
        // 确定第一行的字母数
        int line = 2 + 2 * (row - 2);
        int size = length / line;
        int column = 0;
        if (length == line * size) {
            column = 2 * size;
        } else {
            column = 2 * (size + 1);
        }

        char[][] dp = new char[column][row];
        boolean[][] dpb = new boolean[column][row];

        int index = 0;
        for (int i = 0; i < column; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < row; j++) {
                    if (index < length) {
                        dp[i][j] = array[index];
                        dpb[i][j] = true;
                        index++;
                    }
                }
            } else {
                for (int j = row - 2; j > 0; j--) {
                    if (index < length) {
                        dp[i][j] = array[index];
                        dpb[i][j] = true;
                        index++;
                    }
                }
            }
        }

        index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (dpb[j][i]) {
                    array[index] = dp[j][i];
                    index++;
                }
            }
        }

        return new String(array);
    }
}
