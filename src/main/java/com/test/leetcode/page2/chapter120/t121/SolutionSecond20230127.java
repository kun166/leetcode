package com.test.leetcode.page2.chapter120.t121;

/**
 * @ClassName: Solution20230127
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 10:25
 * @Version: 1.0
 */
public class SolutionSecond20230127 {

    /**
     * 呃，居然写出来了？
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int earn = 0, buyDay = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[buyDay] > earn) {
                earn = prices[i] - prices[buyDay];
            } else if (prices[i] < prices[buyDay]) {
                buyDay = i;
            }
        }
        return earn;
    }
}
