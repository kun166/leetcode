package com.test.leetcode.page5.chapter410.t416;

/**
 * @ClassName: OfficialSecond20230529
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/29 16:34
 * @Version: 1.0
 */
public class OfficialSecond20230529 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        // 前面都一样
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                // 从大到小，因为从小到大就会被覆盖了
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}
