package com.test.leetcode.page2.chapter120.t125;

/**
 * @ClassName: Solution20230127
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 20:22
 * @Version: 1.0
 */
public class Solution20230127 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                builder.append(c);
            }
        }
        s = builder.toString();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
