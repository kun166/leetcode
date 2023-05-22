package com.test.leetcode.page4.chapter320.t322;

import java.util.Arrays;

/**
 * @ClassName: Solution20230428
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/28 08:28
 * @Version: 1.0
 */
public class Solution20230428 {

    /**
     * 执行用时：13 ms, 在所有 Java 提交中击败了51.73%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了5.07%的用户
     * 通过测试用例：189 / 189
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] array = new int[amount + 1];
        Arrays.fill(array, -1);
        array[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int count = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && array[i - coin] != -1) {
                    count = Math.min(count, array[i - coin] + 1);
                }
            }
            if (count != Integer.MAX_VALUE) {
                array[i] = count;
            }
        }
        return array[amount];
    }
}
