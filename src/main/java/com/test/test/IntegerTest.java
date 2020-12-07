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
}
