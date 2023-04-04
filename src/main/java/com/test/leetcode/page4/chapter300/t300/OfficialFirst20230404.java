package com.test.leetcode.page4.chapter300.t300;

/**
 * @ClassName: OfficialFirst20230404
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/4 17:02
 * @Version: 1.0
 */
public class OfficialFirst20230404 {

    /**
     * 方法一：动态规划
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
