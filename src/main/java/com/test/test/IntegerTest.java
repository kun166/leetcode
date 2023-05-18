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
        System.out.println(370921197207141561L % 8);
    }

    @Test
    public void test3() {
        double d = 1 - 0.5d / 100d;
        double ans = 1;
        for (int i = 0; i < 400; i++) {
            ans *= d;
        }
        System.out.println(1 - ans);
    }

    @Test
    public void test4() {
        int start = 0;
        for (; start < 10; start++) {
            if (start == 5) {
                break;
            }
        }
        System.out.println(start);
    }
}
