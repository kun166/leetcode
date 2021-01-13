package com.test.test;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-09 20:24
 */
public class IntegerTest {

    @Test
    public void test() {
        int n = 1000000;
        System.out.println(n * n);
    }

    @Test
    public void test1() {
        int n = 1;
        for (int i = 0; i < 5; i++) {
            n <<= 1;
            System.out.println(n);
        }
    }

    @Test
    public void test2() {

        System.out.println(0 >> 1);
    }

    @Test
    public void test3() {
        long h = Integer.MAX_VALUE * 19L;
        System.out.println(h);
        System.out.println(h >>> 16);
        System.out.println(Long.toBinaryString(h ^ (h >>> 16)));
    }

    @Test
    public void test4() {
        System.out.println(Integer.numberOfLeadingZeros(0));
        System.out.println(Integer.numberOfLeadingZeros(1));
    }

    @Test
    public void test5() {
        System.out.println((int) 'i');

    }


}
