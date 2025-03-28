package com.test.leetcode.page3.chapter210.t214;

/**
 * @ClassName: Solution2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 17:24
 * @Version: 1.0
 */
public class Solution2025032801 {

    /**
     * 只能说尝试下……
     * <p>
     * 呃,这题好像是翻转之后对比?
     * <p>
     * 输入s = "ababbbabbaba"
     * 输出"ababbabbbabababbaba"
     * 预期结果"ababbabbbababbbabbaba"
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        StringBuilder builder = new StringBuilder(s);
        builder.reverse();
        if (builder.toString().equals(s)) {
            return s;
        }
        int left = 0;
        while (++left < n) {
            /**
             *
             */
            if (s.indexOf(builder.substring(left)) > -1) {
                return builder + s.substring(s.length() - left);
            }
        }
        return null;
    }
}
