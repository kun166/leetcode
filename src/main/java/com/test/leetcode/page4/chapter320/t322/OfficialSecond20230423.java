package com.test.leetcode.page4.chapter320.t322;

import java.util.Arrays;

/**
 * @ClassName: OfficialSecond20230423
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/23 09:45
 * @Version: 1.0
 */
public class OfficialSecond20230423 {

    /**
     * 动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
