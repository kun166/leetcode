package com.test.leetcode.page1.chapter0.t9;

import org.junit.Test;

/**
 * @ClassName: Solution20250210
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/10 17:35
 * @Version: 1.0
 */
public class Solution20250210 {

    @Test
    public void test() {
        System.out.println(isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long number = 0;
        int n = x;
        while (x > 0) {
            number = number * 10 + x % 10;
            x = x / 10;
        }
        if (number > Integer.MAX_VALUE)
            return false;
        return number == n;
    }
}
