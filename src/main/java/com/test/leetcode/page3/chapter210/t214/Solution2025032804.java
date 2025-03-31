package com.test.leetcode.page3.chapter210.t214;

import org.junit.Test;

/**
 * @ClassName: Solution20230224
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/24 11:17
 * @Version: 1.0
 */
public class Solution2025032804 {

    @Test
    public void test() {
        System.out.println(shortestPalindrome("a"));
    }

    /**
     * 呃,20250328发现以前的一个解法居然过了?
     * 自己都不理解了?
     * <p>
     * 好吧,优化了一下,居然都 超出时间限制 了……
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            int cl = left, cr = right;
            while (s.charAt(cl) != s.charAt(cr)) {
                cr--;
            }
            right = cr - 1;
            while (cl < cr && s.charAt(cl) == s.charAt(cr)) {
                cl++;
                cr--;
            }
            if (cl >= cr) {
                //
                if (cl == cr) {
                    // 说明中间是一个aba的形式
                    return new StringBuffer(s.substring(cl * 2 + 1)).reverse() + s;
                }
                // 说明中间是一个abba的形式
                return new StringBuffer(s.substring(cl * 2)).reverse() + s;
            }
        }
        return s;
    }
}
