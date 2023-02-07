package com.test.leetcode.page2.chapter150.t151;

/**
 * @ClassName: Solution20230207
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/7 09:25
 * @Version: 1.0
 */
public class SolutionFirst20230207 {

    /**
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        boolean hasBlank = true;
        int end = s.length(), index = end - 1;
        for (; index >= 0; index--) {
            if (s.charAt(index) == ' ') {
                if (hasBlank) {
                    end--;
                } else {
                    builder.append(s, index + 1, end).append(' ');
                    end = index;
                    hasBlank = true;
                }
            } else {
                hasBlank = false;
            }
        }
        if (s.charAt(0) == ' ') {
            builder.deleteCharAt(builder.length() - 1);
        } else {
            builder.append(s, 0, end);
        }
        return builder.toString();
    }
}
