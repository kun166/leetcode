package com.test.leetcode.page5.chapter410.t416;

import org.junit.Test;

/**
 * @ClassName: Solution20230720
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/20 08:57
 * @Version: 1.0
 */
public class Solution20230720 {

    @Test
    public void test() {
        System.out.println(canPartition(new int[]{1, 2, 5}));
    }

    /**
     * 执行用时：21 ms, 在所有 Java 提交中击败了90.72%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了87.56%的用户
     * 通过测试用例：141 / 141
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = half; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
            if (dp[half]) {
                return true;
            }
        }
        return false;
    }
}
