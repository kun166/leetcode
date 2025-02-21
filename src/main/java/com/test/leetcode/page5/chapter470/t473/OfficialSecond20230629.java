package com.test.leetcode.page5.chapter470.t473;

import java.util.Arrays;

/**
 * @ClassName: OfficialSecond20230629
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/29 15:34
 * @Version: 1.0
 */
public class OfficialSecond20230629 {

    /**
     * 方法二：状态压缩 + 动态规划
     *
     * @param matchsticks
     * @return
     */
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4, n = matchsticks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }
}
