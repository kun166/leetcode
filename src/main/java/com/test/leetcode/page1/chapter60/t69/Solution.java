package com.test.leetcode.page1.chapter60.t69;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-09 20:26
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(mySqrt(2));
    }

    public int mySqrt(int x) {
        for (int i = 0; i <= x; i++) {
            int num = i * i;
            if (num == x)
                return i;
            else if (num > x || num < 0)
                return i - 1;
        }
        return -1;
    }
}
