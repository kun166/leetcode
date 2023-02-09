package com.test.leetcode.page2.chapter160.t168;

import org.junit.Test;

/**
 * @ClassName: Solution20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 10:03
 * @Version: 1.0
 */
public class Solution20230209 {

    @Test
    public void test() {
        System.out.println(convertToTitle(52));
        //System.out.println(convertToTitle(2147483647));
    }

    /**
     * 这题其实就是26进制
     *
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            int index = columnNumber % 26;
            boolean isZ = false;
            if (index == 0) {
                builder.append('Z');
                isZ = true;
            } else {
                builder.append((char) ('A' + index - 1));
            }
            columnNumber /= 26;
            if (isZ) {
                columnNumber -= 1;
            }
        }
        return builder.reverse().toString();
    }
}
