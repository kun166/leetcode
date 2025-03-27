package com.test.leetcode.page3.chapter200.t204;

import java.util.*;

/**
 * @ClassName: Official2025032701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/27 09:22
 * @Version: 1.0
 */
public class Official2025032702 {

    /**
     * 埃氏筛
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
