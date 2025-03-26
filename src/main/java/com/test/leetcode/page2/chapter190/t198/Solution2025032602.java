package com.test.leetcode.page2.chapter190.t198;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 09:05
 * @Version: 1.0
 */
public class Solution2025032602 {


    /**
     * 动态规划
     * <p>
     * 就两个状态,偷/不偷
     * <p>
     * 0ms	击败100.00%
     * 40.32MB	击败29.37%
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        /**
         * dp[i][0] 第i+1天不偷时,偷到的最大钱数
         * dp[i][1] 第i+1天偷时,偷到的最大钱数
         */
        int[][] dp = new int[n][2];
        /**
         * 初始化
         */
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            /**
             * 不偷,那今天最大的钱数,从昨天偷了和没偷取最大数
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

            /**
             * 偷, 只有昨天没偷,今天才可以偷
             */
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }


}
