package com.test.leetcode.page2.chapter120.t125;

/**
 * @ClassName: Solution2025031302
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/13 17:27
 * @Version: 1.0
 */
public class Solution2025031302 {
    int differ = 'a' - 'A';

    /**
     * 双指针吧
     * 2ms	击败96.91%
     * 42.23MB	击败72.26%
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

            /**
             * 相同的情况有如下两种
             * 1,两个字符相同
             * 2,两个字符均为字母,且相差'a'-'A'
             *
             * if (!(s.charAt(left) == s.charAt(right) || (!isDigit(s.charAt(left)) && !isDigit(s.charAt(right))
             *                     && Math.abs(s.charAt(left) - s.charAt(right)) != differ)))
             * 转换成
             * if (s.charAt(left) != s.charAt(right) && !(!isDigit(s.charAt(left)) && !isDigit(s.charAt(right))
             *                     && Math.abs(s.charAt(left) - s.charAt(right)) != differ))
             * 转换成
             * if (s.charAt(left) != s.charAt(right) &&(isDigit(s.charAt(left))||isDigit(s.charAt(right))
             *                     ||Math.abs(s.charAt(left) - s.charAt(right)) != differ))
             */
            if (s.charAt(left) != s.charAt(right) && (isDigit(s.charAt(left)) || isDigit(s.charAt(right))
                    || Math.abs(s.charAt(left) - s.charAt(right)) != differ))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean valid(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
