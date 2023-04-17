package com.test.leetcode.page4.chapter310.t313;

/**
 * @ClassName: Other20230417
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/17 09:21
 * @Version: 1.0
 */
public class Other20230417 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n];
        ans[0] = 1;
        int[] indexes = new int[primes.length];
        int[] priSum = new int[primes.length];
        for (int i = 0; i < primes.length; i++) {
            priSum[i] = primes[i] * ans[indexes[i]];
        }
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < priSum.length; j++) {
                if (priSum[j] > 0) {
                    min = Math.min(min, priSum[j]);
                }
            }
            ans[i] = min;
            for (int j = 0; j < priSum.length; j++) {
                if (priSum[j] == min) {
                    indexes[j]++;
                    priSum[j] = primes[j] * ans[indexes[j]];
                }
            }
        }
        return ans[n - 1];

    }
}
