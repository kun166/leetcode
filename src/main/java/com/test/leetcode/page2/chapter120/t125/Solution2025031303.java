package com.test.leetcode.page2.chapter120.t125;

/**
 * @ClassName: Solution2025031303
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/14 09:05
 * @Version: 1.0
 */
public class Solution2025031303 {

    int differ = 'a' - 'A';

    /**
     * 双指针吧
     * 2ms	击败96.91%
     * 42.02MB	击败91.18%
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {

            while (left < right && !valid(s.charAt(left)))
                left++;
            while (left < right && !valid(s.charAt(right)))
                right--;

            if (toLowerCase(s.charAt(left++)) != toLowerCase(s.charAt(right--)))
                return false;
        }
        return true;
    }

    public boolean valid(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    public char toLowerCase(char c) {
        if (c > 'Z' || c < 'A')
            return c;
        return (char) (c + differ);
    }
}
