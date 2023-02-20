package com.test.leetcode.page3.chapter200.t204;

import org.junit.Test;

/**
 * @ClassName: Solution20230220
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/20 09:09
 * @Version: 1.0
 */
public class Solution20230220 {

    @Test
    public void test() {
        System.out.println(countPrimes(10));
    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean prime(int n) {
        if (n <= 3) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
            if (n < i * i) {
                break;
            }
        }
        return true;
    }
}
