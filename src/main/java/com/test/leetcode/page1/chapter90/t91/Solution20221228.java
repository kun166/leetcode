package com.test.leetcode.page1.chapter90.t91;

import org.junit.Test;

/**
 * @ClassName: Solution20221228
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/28 09:12
 * @Version: 1.0
 */
public class Solution20221228 {

    @Test
    public void test() {
        System.out.println(numDecodings("101"));
    }

    /**
     * 这题类似于斐波那契函数啊
     * 咱这解法是从后往前
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        int first = s.charAt(length - 1) == '0' ? 0 : 1;
        int second = s.charAt(length - 2) == '0' ? 0 : (first + (Integer.parseInt(s.substring(length - 2)) > 26 ? 0 : 1));
        for (int i = 3; i <= length; i++) {
            int third = s.charAt(length - i) == '0' ? 0 : (second + (Integer.parseInt(s.substring(length - i, length - i + 2)) > 26 ? 0 : first));
            first = second;
            second = third;
        }
        return second;
    }
}
