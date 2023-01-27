package com.test.leetcode.page2.chapter120.t121;

/**
 * @ClassName: Solution20230127
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 10:16
 * @Version: 1.0
 */
public class SolutionFirst20230127 {

    /**
     * 好吧，超出时间限制了，汗
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int earn = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    earn = Math.max(earn, prices[j] - prices[i]);
                }
            }
        }
        return earn;
    }
}
