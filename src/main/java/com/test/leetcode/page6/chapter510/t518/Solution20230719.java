package com.test.leetcode.page6.chapter510.t518;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution20230719
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/19 09:13
 * @Version: 1.0
 */
public class Solution20230719 {

    @Test
    public void test() {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for (int i : coins) {
            dp[i] = 1;
        }
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                if (i >= coins[j]) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        return dp[amount];
    }
}
