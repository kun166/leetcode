package com.test.leetcode.page2.chapter190.t198;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 09:05
 * @Version: 1.0
 */
public class Solution2025032603 {


    /**
     * 动态规划
     * <p>
     * 继续优化空间
     * <p>
     * 0ms	击败100.00%
     * 40.16MB	击败68.21%
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[2];

        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            int money = dp[0];
            dp[0] = Math.max(dp[0], dp[1]);
            dp[1] = money + nums[i];
        }
        return Math.max(dp[0], dp[1]);
    }


}
