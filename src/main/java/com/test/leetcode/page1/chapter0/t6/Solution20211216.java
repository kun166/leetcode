package com.test.leetcode.page1.chapter0.t6;

/**
 * @ClassName: Solution20211216
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/12/16 19:03
 * @Version: 1.0
 */
public class Solution20211216 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuffer[] array = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            array[i] = new StringBuffer();
        }
        int index = 0, step = 1;
        for (char c : s.toCharArray()) {
            array[index].append(c);
            index += step;
            if (index == 0 || index == numRows - 1) {
                step = -step;
            }
        }
        for (int i = 1; i < numRows; i++) {
            array[0].append(array[i]);
        }
        return array[0].toString();
    }
}
