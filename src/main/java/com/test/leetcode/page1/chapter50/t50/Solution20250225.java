package com.test.leetcode.page1.chapter50.t50;

import org.junit.Test;

/**
 * @ClassName: Solution20250225
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/25 17:02
 * @Version: 1.0
 */
public class Solution20250225 {

    @Test
    public void test() {
        System.out.println(myPow(2.0d, -2147483648));
    }

    /**
     * 原理……?
     * n分解成2的指数?
     * 比如 10 = 0*2(0)+1*2(1)+0*2(2)+1*2(3)
     * <p>
     * 输入
     * x = 2.00000
     * n = -2147483648
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        boolean moreThanZero = n >= 0;
        long ln = n;
        ln = moreThanZero ? ln : -ln;
        double ans = 1d;
        double d = x;
        while (ln > 0) {
            if ((ln & 1) == 1) {
                ans *= d;
            }
            ln /= 2;
            d *= d;
        }
        return moreThanZero ? ans : 1 / ans;
    }
}
