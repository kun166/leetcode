package com.test.leetcode.page6.chapter510.t518;

/**
 * @ClassName: Solution20230808
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/8 10:54
 * @Version: 1.0
 */
public class Solution20230808 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.53%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了61.28%的用户
     * 通过测试用例：28 / 28
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    dp[j] += dp[j - coin];
                }
            }
        }
        return dp[amount];
    }
}
