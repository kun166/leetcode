package com.test.leetcode.chapter0.t9;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-11 17:14
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(isSymmetry(121));
        System.out.println(isSymmetry(10));
        System.out.println(isSymmetry(12321));
        System.out.println(isSymmetry(-11));
        System.out.println(isSymmetry(1));
    }


    public boolean isSymmetry(int number) {
        if (number < 0) {
            return false;
        }

        int copy = number;
        int re = 0;

        while (copy != 0) {
            int pop = copy % 10;
            re = re * 10 + pop;
            copy = copy / 10;
        }
        if (re == number) {
            return true;
        }
        return false;
    }
}
