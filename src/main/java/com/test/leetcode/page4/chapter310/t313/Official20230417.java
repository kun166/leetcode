package com.test.leetcode.page4.chapter310.t313;

import java.util.Arrays;

/**
 * @ClassName: Official20230417
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/17 09:22
 * @Version: 1.0
 */
public class Official20230417 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        int m = primes.length;
        int[] pointers = new int[m];
        int[] nums = new int[m];
        Arrays.fill(nums, 1);
        for (int i = 1; i <= n; i++) {
            int minNum = Arrays.stream(nums).min().getAsInt();
            dp[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (nums[j] == minNum) {
                    pointers[j]++;
                    nums[j] = dp[pointers[j]] * primes[j];
                }
            }
        }
        return dp[n];
    }
}
