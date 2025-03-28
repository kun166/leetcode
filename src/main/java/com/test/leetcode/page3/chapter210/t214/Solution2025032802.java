package com.test.leetcode.page3.chapter210.t214;

/**
 * @ClassName: Solution2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 17:24
 * @Version: 1.0
 */
public class Solution2025032802 {

    /**
     * 超出时间限制
     * <p>
     * 感觉得kms?
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
            if (s.indexOf(builder.substring(left)) == 0) {
                return builder + s.substring(s.length() - left);
            }
        }
        return null;
    }
}
