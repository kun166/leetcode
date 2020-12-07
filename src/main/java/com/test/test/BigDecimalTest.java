package com.test.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-27 16:02
 */
public class BigDecimalTest {

    @Test
    public void test() {
        BigDecimal b = new BigDecimal("0.0");
        System.out.println(b.compareTo(new BigDecimal("0")));
    }

    @Test
    public void test1(){
        System.out.println(Integer.toBinaryString(2));
    }
}
