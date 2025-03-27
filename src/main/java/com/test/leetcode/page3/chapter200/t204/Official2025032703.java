package com.test.leetcode.page3.chapter200.t204;

import java.util.*;

/**
 * @ClassName: Official2025032701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/27 09:22
 * @Version: 1.0
 */
public class Official2025032703 {

    /**
     * 线性筛
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
