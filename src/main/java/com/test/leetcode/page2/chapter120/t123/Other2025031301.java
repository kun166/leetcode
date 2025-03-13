package com.test.leetcode.page2.chapter120.t123;

/**
 * @ClassName: Other2025031301
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/13 15:24
 * @Version: 1.0
 */
public class Other2025031301 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        /**
         * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/solutions/71792/dong-tai-gui-hua-by-liweiwei1419-7/
         * 第一维表示当前天数,
         * 第二维表示进行的交易次数,
         * 第三维表示交易的状态,0标识不持有股票,1标识持有股票
         *
         * dp[i][j][k]标识:第i天进行了j次交易,状态为k时候,赚取的钱数
         */
        // 第 2 维的 0 没有意义，1 表示交易进行了 1 次，2 表示交易进行了 2 次
        // 为了使得第 2 维的数值 1 和 2 有意义，这里将第 2 维的长度设置为 3
        int[][][] dp = new int[len][3][2];

        // 理解如下初始化
        // 第 3 维规定了必须持股，因此是 -prices[0]
        dp[0][1][1] = -prices[0];
        // 第一天买了一次卖了一次,又买了一次
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 转移顺序先持股，再卖出
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
        }
        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);
    }
}
