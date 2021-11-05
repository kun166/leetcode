package com.test.leetcode.page1.chapter20.t29;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-26 17:58
 */
public class Solution20201026 {

    @Test
    public void test() {
        //System.out.println(Integer.MIN_VALUE);
        System.out.println(divide(-2147483648, 2));
    }


    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean same = (dividend < 0 && divisor < 0) || (dividend >= 0 && divisor > 0);

        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;
        if (divisor < dividend) return 0;


        int times = 1;
        int[] divisorA = new int[32];
        int[] timesA = new int[32];

        int index = 0;
        divisorA[index] = divisor;
        timesA[index] = times;

        while (dividend - divisor < divisor) {
            divisor += divisor;
            times += times;

            index++;
            divisorA[index] = divisor;
            timesA[index] = times;
        }
        int result = 0;
        while (index >= 0) {
            if (dividend <= divisorA[index]) {
                dividend -= divisorA[index];
                result += timesA[index];
            }
            index--;
        }
        if (dividend <= divisorA[0]) {
            result += timesA[0];
        }
        return same ? result : -result;
    }
}
