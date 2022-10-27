package com.test.leetcode.page1.chapter20.t29;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20221026
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/26 19:17
 * @Version: 1.0
 */
public class Solution20221026 {

    @Test
    public void test() {
        System.out.println(divide(1, -1));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int count = 1;
        while (dividend <= divisor) {
            l1.add(divisor);
            l2.add(count);
            if (Integer.MIN_VALUE - divisor > divisor) {
                break;
            }
            divisor += divisor;
            count += count;
        }
        int ans = 0;
        for (int i = l1.size() - 1; i >= 0; i--) {
            while (dividend <= l1.get(i)) {
                ans += l2.get(i);
                dividend -= l1.get(i);
            }
        }
        return flag ? ans : -ans;
    }
}
