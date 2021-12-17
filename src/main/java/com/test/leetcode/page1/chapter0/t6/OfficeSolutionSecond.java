package com.test.leetcode.page1.chapter0.t6;

/**
 * @ClassName: OfficeSolutionSecond
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/12/16 19:18
 * @Version: 1.0
 */
public class OfficeSolutionSecond {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder ret = new StringBuilder();
        // 字符串长度
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        /**
         * 行0中的字符位于索引k(2⋅numRows−2)处;
         * 行numRows−1中的字符位于索引k(2⋅numRows−2)+numRows−1处;
         * 内部的行i中的字符位于索引k(2⋅numRows−2)+i以及(k+1)(2⋅numRows−2)−i 处;
         */
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
