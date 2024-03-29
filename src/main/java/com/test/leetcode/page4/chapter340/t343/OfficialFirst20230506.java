package com.test.leetcode.page4.chapter340.t343;

/**
 * @ClassName: Official20230506
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/6 08:15
 * @Version: 1.0
 */
public class OfficialFirst20230506 {

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
