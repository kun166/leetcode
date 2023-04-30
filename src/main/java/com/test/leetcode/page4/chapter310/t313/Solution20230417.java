package com.test.leetcode.page4.chapter310.t313;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20230417
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/17 09:02
 * @Version: 1.0
 */
public class Solution20230417 {

    @Test
    public void test() {
        System.out.println(nthSuperUglyNumber(5911, new int[]{2, 3, 5, 7}));
    }


    /**
     * 执行用时：54 ms, 在所有 Java 提交中击败了68.94%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了95.15%的用户
     * 通过测试用例：87 / 87
     *
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];
        dp[0] = 1;
        int[] count = new int[primes.length];
        for (int i = 1; i < n; i++) {
            dp[i] = Long.MAX_VALUE;
            for (int j = 0; j < count.length; j++) {
                dp[i] = Math.min(dp[i], dp[count[j]] * primes[j]);
            }
            for (int j = 0; j < count.length; j++) {
                if (dp[i] == dp[count[j]] * primes[j]) {
                    count[j]++;
                }
            }
        }
        return (int) dp[n - 1];
    }
}
