package com.test.leetcode.page2.chapter180.t188;

import java.util.Arrays;

/**
 * @ClassName: OfficialFirst20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 10:15
 * @Version: 1.0
 */
public class OfficialFirst20230215 {

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // 对k进行优化。当天买卖股票没意义，买入和卖出不在同一天，所以最多有n/2次交易
        k = Math.min(k, n / 2);
        // buy[i][j] 表示对于数组prices[0..i] 中的价格而言，进行恰好j笔交易，并且当前手上持有一支股票，这种情况下的最大利润；
        // buy[i][j] 这只股票是当天(第i+1天)买的，则利润为前一天卖出的收益减去当前的股票价格 sell[i−1][j]-prices[i]
        // 如果这只股票不是当天买的,则收益和昨天的一样，即sell[i-1][j]
        // 因此buy[i][j]的最大收益为Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i])
        int[][] buy = new int[n][k + 1];
        // sell[i][j] 表示对于数组prices[0..i] 中的价格而言，恰好进行 j 笔交易，并且当前手上不持有股票，这种情况下的最大利润。
        // 如果这只股票是当天(第i+1天)卖的，则昨天持有这只股票，收益为buy[i-1][j-1]+prices[i]
        // 如果这只股票是以前卖的，则当前收益为sell[i-1][j]
        // 因此sell[i][j]的当前最大收益为Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i])
        int[][] sell = new int[n][k + 1];
        // 只是买入，进行了0比交易，手上有一只股票
        buy[0][0] = -prices[0];
        // 进行了0比交易，手上无股票
        sell[0][0] = 0;

        // 边界问题，
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            // 第一层循环，是循环的天数
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                // 第二层循环，是循环的买卖股票次数
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
}
