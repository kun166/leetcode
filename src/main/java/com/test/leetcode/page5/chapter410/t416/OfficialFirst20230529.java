package com.test.leetcode.page5.chapter410.t416;

/**
 * @ClassName: OfficialFirst20230529
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/29 16:08
 * @Version: 1.0
 */
public class OfficialFirst20230529 {

    /**
     * 呃，又是动态规划……
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        // 长度
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        // 求累加和，求最大值
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        // 累加和是奇数，则返回false
        if (sum % 2 != 0) {
            return false;
        }
        // 目标是累加和一半
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }

        // dp[i][j]表示从下标为0到i的数组中中选取若干个数，之和是否为j
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            // 一个正数都不选的时候，和为0
            dp[i][0] = true;
        }
        // 只有0一个下标的时候，dp[0][nums[0]]也是true
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            // 遍历1到n-1的所有下标
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                // 和从1到target一共target个数
                if (j >= num) {
                    // 如果j>=num，则有选择或者不选择两种情况
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    // 否则只有不选一种情况
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}
