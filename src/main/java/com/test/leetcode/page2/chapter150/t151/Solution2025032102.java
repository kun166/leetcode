package com.test.leetcode.page2.chapter150.t151;

/**
 * @ClassName: Solution2025032102
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/21 11:33
 * @Version: 1.0
 */
public class Solution2025032102 {

    /**
     * 3ms	击败92.09%
     * 41.79MB	击败75.63%
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int left = s.length() - 1, right = s.length();
        while (left >= 0) {
            if (s.charAt(left) == ' ') {
                if (left != right - 1) {
                    builder.append(s.substring(left + 1, right)).append(' ');
                }
                right = left;
            }
            left--;
        }
        if (left != right - 1) {
            builder.append(s.substring(left + 1, right)).append(' ');
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
