package com.test.test;

/**
 * Created by qinfajia on 2020/11/7.
 */
public class Hanoi {

    public void hanoi(int n) {

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
            System.out.println("from ");
        }
    }
}
