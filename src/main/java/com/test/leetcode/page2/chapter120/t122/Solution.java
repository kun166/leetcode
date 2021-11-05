package com.test.leetcode.page2.chapter120.t122;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-06-11 11:15
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int max = 0;
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}
