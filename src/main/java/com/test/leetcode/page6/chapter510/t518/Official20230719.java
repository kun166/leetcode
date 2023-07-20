package com.test.leetcode.page6.chapter510.t518;

/**
 * @ClassName: Official20230719
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/19 10:59
 * @Version: 1.0
 */
public class Official20230719 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
