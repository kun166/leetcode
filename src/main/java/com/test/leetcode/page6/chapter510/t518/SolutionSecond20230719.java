package com.test.leetcode.page6.chapter510.t518;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: SolutionSecond20230719
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/19 10:19
 * @Version: 1.0
 */
public class SolutionSecond20230719 {

    int ans = 0;

    @Test
    public void test() {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }

    /**
     * 超出时间限制了
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        change(amount, coins, coins.length - 1);
        return ans;
    }

    public void change(int amount, int[] coins, int index) {
        if (amount == 0) {
            ans++;
            return;
        }
        if (amount < 0) {
            return;
        }
        for (int i = index; i >= 0; i--) {
            change(amount - coins[i], coins, i);
        }
    }
}
