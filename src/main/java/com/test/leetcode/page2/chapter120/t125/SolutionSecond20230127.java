package com.test.leetcode.page2.chapter120.t125;

/**
 * @ClassName: SolutionSecond20230127
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 20:33
 * @Version: 1.0
 */
public class SolutionSecond20230127 {

    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            char left = s.charAt(start);
            while (!isValid(left) && start < end) {
                left = s.charAt(++start);
            }
            if (start == end) {
                return true;
            }
            char right = s.charAt(end);
            while (!isValid(right) && start < end) {
                right = s.charAt(--end);
            }
            if (start == end) {
                return true;
            }
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isValid(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}
