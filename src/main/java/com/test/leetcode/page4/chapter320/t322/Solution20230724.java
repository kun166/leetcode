package com.test.leetcode.page4.chapter320.t322;

import java.util.Arrays;

/**
 * @ClassName: Solution20230724
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/24 09:55
 * @Version: 1.0
 */
public class Solution20230724 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j : coins) {
                if (i >= j && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
