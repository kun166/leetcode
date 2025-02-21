package com.test.leetcode.page1.chapter0.t6;

import org.junit.Test;

/**
 * @ClassName: Solution20250210
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/10 15:49
 * @Version: 1.0
 */
public class Solution20250210 {

    @Test
    public void test() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    /**
     * 看了题解，温故下吧
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 一个周期的字符串数量是2*numRows-2,来回折行除去上下两行
        int cyclic = 2 * numRows - 2;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            // 双层循环，外层按行循环
            for (int j = 0; j + i < s.length(); j = j + cyclic) {
                // 内层按列循环。j+i是当前字符的位置,保证不超过s的长度
                builder.append(s.charAt(j + i));
                // 除了第一行和最后一行,其它行有两个字符
                if (i != 0 && i != numRows - 1 && j + cyclic - i < s.length()) {
                    builder.append(s.charAt(j + cyclic - i));
                }
            }
        }
        return builder.toString();
    }
}
