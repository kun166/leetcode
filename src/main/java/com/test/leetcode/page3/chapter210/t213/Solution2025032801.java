package com.test.leetcode.page3.chapter210.t213;

/**
 * @ClassName: Solution2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 16:37
 * @Version: 1.0
 */
public class Solution2025032801 {

    /**
     * 这道题,肯定是动态规划了
     * <p>
     * 0ms	击败100.00%
     * 40.12MB	击败85.84%
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        /**
         * dp[i][j]
         * 第一位是第一个房间没偷/偷了(0/1)
         * 第二位是当前房间没偷/偷了(0/1)
         * 的最大值
         */
        int[][] dp = new int[2][2];
        // 初始化
        dp[1][1] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            // 1,第一个房间没偷
            int number = dp[0][0];
            // 1.1,今天不偷
            dp[0][0] = Math.max(number, dp[0][1]);
            // 1.2,今天偷
            dp[0][1] = number + nums[i];

            // 2,第一个房间偷了
            number = dp[1][0];
            // 2.1,今天不偷
            dp[1][0] = Math.max(number, dp[1][1]);
            // 2.2,今天偷
            dp[1][1] = number + nums[i];
        }
        return Math.max(Math.max(dp[0][0] + nums[nums.length - 1], dp[0][1]), Math.max(dp[1][0], dp[1][1]));
    }
}
