package com.test.leetcode.page2.chapter120.t125;

/**
 * @ClassName: Solution2025031301
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/13 16:55
 * @Version: 1.0
 */
public class Solution2025031301 {

    int differ = 'a' - 'A';

    /**
     * 双指针吧
     * 4ms	击败48.50%
     * 42.25MB	击败70.45%
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            /**
             * 唉，这个地方没加left < right,错了
             */
            while (left < right && !valid(s.charAt(left)))
                left++;
            while (left < right && !valid(s.charAt(right)))
                right--;
            /**
             * 下面"0P"错了,晕了
             * if (s.charAt(left) != s.charAt(right) && Math.abs(s.charAt(left) - s.charAt(right)) != differ)
             */
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--)))
                return false;
        }
        return true;
    }

    public boolean valid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
