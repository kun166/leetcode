package com.test.leetcode.page2.chapter120.t125;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-12 19:42
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(isPalindrome("ab_a"));
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int dif = 'A' - 'a';
        int start = 0, end = s.length() - 1;
        while (start < end) {
            char startC = s.charAt(start);
            if (!((startC >= 'A' && startC <= 'Z') || (startC >= 'a' && startC <= 'z') || (startC >= '0' && startC <= '9'))) {
                start++;
                continue;
            }
            char endC = s.charAt(end);
            if (!((endC >= 'A' && endC <= 'Z') || (endC >= 'a' && endC <= 'z') || (endC >= '0' && endC <= '9'))) {
                end--;
                continue;
            }
            if (startC != endC) {
                if ((startC >= '0' && startC <= '9') || (endC >= '0' && endC <= '9')) {
                    return false;
                }
                if (startC - endC != dif && startC - endC != -dif) {
                    return false;
                }
            }
            start++;
            end--;
        }
        return true;
    }
}
