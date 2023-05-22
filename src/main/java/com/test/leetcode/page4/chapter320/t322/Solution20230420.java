package com.test.leetcode.page4.chapter320.t322;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution20230420
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/20 08:52
 * @Version: 1.0
 */
public class Solution20230420 {

    @Test
    public void test() {
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    boolean pass = false;
    int count = Integer.MAX_VALUE;


    /**
     * 超出时间限制
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        coinChange(coins, amount, coins.length - 1, 0);
        return pass ? count : -1;
    }

    public void coinChange(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            pass = true;
            this.count = Math.min(this.count, count);
            return;
        }
        for (int i = index; i >= 0; i--) {
            if (coins[i] <= amount) {
                coinChange(coins, amount - coins[i], i, count + 1);
            }
        }
    }
}
