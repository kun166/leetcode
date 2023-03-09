package com.test.leetcode.page3.chapter230.t233;

import org.junit.Test;

/**
 * @ClassName: Official20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 09:38
 * @Version: 1.0
 */
public class Solution20230309 {

    @Test
    public void test() {
        System.out.println(countDigitOne(1));
    }

    /**
     * 看着官方解，自己写的
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int ans = 0;
        long k = 1;
        while (n >= k) {
            ans += (n / (k * 10)) * k + Math.min(Math.max(n % (k * 10) - k + 1, 0), k);
            k *= 10;
        }
        return ans;
    }
}
