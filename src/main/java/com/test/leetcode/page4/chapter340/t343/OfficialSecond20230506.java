package com.test.leetcode.page4.chapter340.t343;

/**
 * @ClassName: OfficialSecond20230506
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/6 08:16
 * @Version: 1.0
 */
public class OfficialSecond20230506 {

    /**
     * 方法二：优化的动态规划
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }
}
