package com.test.leetcode.page1.chapter0.t6;

/**
 * @ClassName: OfficeSolutionSecond
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/12/16 19:18
 * @Version: 1.0
 */
public class OfficeSolutionSecond {

    /**
     * 这是这道题一开始会想用的解法，同时也是很麻烦，很难理解的解法
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder ret = new StringBuilder();
        // 字符串长度
        int n = s.length();
        /**
         * P   A   H   N
         * A P L S I I G
         * Y   I   R
         * 从这个图形可以看到，每2*numRows-2(-2是因为偶数列的头尾没有填字母)个字母，一个循环
         */
        int cycleLen = 2 * numRows - 2;
        /**
         * 行0中的字符位于索引k(2⋅numRows−2)处; 即k*cycleLen处。一个循环只有一个字符
         * 行numRows−1中的字符位于索引k(2⋅numRows−2)+numRows−1处;即k*cycleLen+numRows−1处，一个循环只有一个字符
         * 内部的行i中的字符位于索引k(2⋅numRows−2)+i以及(k+1)(2⋅numRows−2)−i 处;即k*cycleLen处+i和k*cycleLen+cycleLen-i处
         * 所以不论是行0还是行numRows−1，还是其它行，都满足k(2⋅numRows−2)+i
         * 但是非0和非numRows−1，还有一个k*cycleLen+cycleLen-i
         */
        for (int i = 0; i < numRows; i++) {
            // i是遍历行numRows
            for (int j = 0; j + i < n; j += cycleLen) {
                // j是 2*numRows-2 的循环
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    // i != 0 && i != numRows - 1 既不是第一个行，也不是最后一行
                    // cycleLen - i是离本次循环开始下标j的距离
                    // 这个单独说明一下,因为j是cycleLen的整数倍，j+cycleLen就是本次周期的最后,当前位置离该位置的距离是i
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
