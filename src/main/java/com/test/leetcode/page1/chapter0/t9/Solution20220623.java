package com.test.leetcode.page1.chapter0.t9;

import org.junit.Test;

/**
 * @ClassName: Solution20220623
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/23 15:24
 * @Version: 1.0
 */
public class Solution20220623 {

    @Test
    public void test() {
        System.out.println(isPalindrome(101));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int i = 0;
        while (x > i) {
            i = i * 10 + x % 10;
            x /= 10;
        }
        if (i == x) {
            return true;
        }
        if (i - 10 * x < 10 && i - 10 * x >= 0) {
            return true;
        }
        return false;
    }
}
