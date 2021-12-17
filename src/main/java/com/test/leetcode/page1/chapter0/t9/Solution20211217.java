package com.test.leetcode.page1.chapter0.t9;

import org.junit.Test;

/**
 * @ClassName: Solution20211217
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/12/17 09:57
 * @Version: 1.0
 */
public class Solution20211217 {

    @Test
    public void test() {
        System.out.println(isPalindrome(121));
    }

    /**
     * 判断传入的x是不是回文数。官方的题解速度更快
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int number = 0;
        while (number < x) {
            int n = number * 10 + x % 10;
            if (number == n) {
                return false;
            }
            number = n;
            x /= 10;

        }
        if (number == x || number / 10 == x) {
            return true;
        }
        return false;
    }
}
