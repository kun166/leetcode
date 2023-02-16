package com.test.leetcode.page2.chapter190.t198;

import org.junit.Test;

/**
 * @ClassName: Solution20230216
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/16 09:38
 * @Version: 1.0
 */
public class Solution20230216 {

    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }


    /**
     * 呃，又是一个dp
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        // dp[0]标识 上一个房间没偷,dp[1]标识上一个房间偷了
        int[] dp = new int[2];
        // 赋初值
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            // 当前房间偷的最大值
            int value = dp[0] + nums[i];
            // 当前房间不偷的最大值
            dp[0] = Math.max(dp[0], dp[1]);
            // 赋值
            dp[1] = value;
        }
        return Math.max(dp[0], dp[1]);
    }
}
