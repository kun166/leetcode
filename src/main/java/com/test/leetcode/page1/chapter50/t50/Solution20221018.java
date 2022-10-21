package com.test.leetcode.page1.chapter50.t50;

import org.junit.Test;

/**
 * @ClassName: Solution20221018
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/18 19:54
 * @Version: 1.0
 */
public class Solution20221018 {

    @Test
    public void test() {
        System.out.println(myPow(2.10d, 3));
    }

    public double myPow(double x, int n) {
        boolean b = n > 0 ? true : false;
        n = b ? n : -n;
        // 速算
        double ant = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ant *= x;
            }
            x *= x;
            n = n / 2;
        }
        return b ? ant : 1 / ant;
    }
}
