package com.test.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-09 20:24
 */
public class IntegerTest {

    @Test
    public void test() {
        BigDecimal bigDecimal = new BigDecimal(1100000L);
        System.out.println(bigDecimal.divide(new BigDecimal("100")));

    }

    @Test
    public void test1() {
        System.out.println(1 << 2);
        System.out.println(-25 / 26);
    }

    @Test
    public void test2() {
        System.out.println(63665318992148L % 8);
    }

    @Test
    public void test3() {
        System.out.println(12&10);
    }
}
