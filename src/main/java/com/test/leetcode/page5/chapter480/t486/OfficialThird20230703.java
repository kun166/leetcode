package com.test.leetcode.page5.chapter480.t486;

/**
 * @ClassName: OfficialThird20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 16:58
 * @Version: 1.0
 */
public class OfficialThird20230703 {

    /**
     * 动态规划--优化
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] >= 0;
    }
}
