package com.test.leetcode.test;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-11 16:54
 */
public class TestCode {

    @Test
    public void test() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE == -2147483648);
    }

    @Test
    public void testBit() {
        int n = 233;
        n <<= 1;
        System.out.println(n);
    }

    @Test
    public void testInteger() {
        System.out.println(new Integer(2) == new Integer(2));
    }

    @Test
    public void test1() {
        int volume = 2 << 10; //2048
        System.out.println(volume);
        int bitNum = volume - 1; //11111111111
        System.out.println(1111111&bitNum);
    }
}
