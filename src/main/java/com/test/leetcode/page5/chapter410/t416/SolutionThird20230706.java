package com.test.leetcode.page5.chapter410.t416;

import org.junit.Test;

/**
 * @ClassName: SolutionThird20230706
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/6 15:56
 * @Version: 1.0
 */
public class SolutionThird20230706 {

    @Test
    public void test() {
        System.out.println(canPartition(new int[]{1, 5, 2}));
    }

    /**
     * 执行用时：68 ms, 在所有 Java 提交中击败了5.18%的用户
     * 内存消耗：43.9 MB, 在所有 Java 提交中击败了32.28%的用户
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
        //dp[i][j] 前i个数合和是j
        boolean[][] dp = new boolean[n + 1][half + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= half; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j == nums[i - 1]) {
                    dp[i][j] = true;
                } else if (j - nums[i - 1] > 0) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][half];
    }
}
