package com.test.leetcode.page2.chapter120.t122;

/**
 * @ClassName: Solution20230127
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 10:57
 * @Version: 1.0
 */
public class Solution20230127 {

    public int maxProfit(int[] prices) {
        int earn = 0, buyDay = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[buyDay]) {
                earn += prices[i] - prices[buyDay];
            }
            buyDay = i;
        }
        return earn;
    }
}
