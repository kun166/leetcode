package com.test.test;

import org.junit.Test;

/**
 * Created by qinfajia on 2020/11/7.
 */
public class Hanoi {

    @Test
    public void test() {
        hanoi(4);
    }


    public void hanoi(int n) {
        hanoi(n, "A", "B", "C");
    }

    /**
     * @param n
     * @param a 原坐标
     * @param b 借助坐标
     * @param c 目的坐标
     */
    public void hanoi(int n, String a, String b, String c) {
        if (n == 1)
            System.out.println(n + " from " + a + " to " + c);
        else if (n == 2) {
            System.out.println(1 + " from " + a + " to " + b);
            System.out.println(2 + " from " + a + " to " + c);
            System.out.println(1 + " from " + b + " to " + c);
        } else {
            hanoi(n - 1, a, c, b);
            System.out.println(n + " from " + a + " to " + c);
            hanoi(n - 1, b, a, c);
        }
    }
}
