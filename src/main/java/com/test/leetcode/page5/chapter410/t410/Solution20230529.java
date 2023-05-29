package com.test.leetcode.page5.chapter410.t410;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution20230529
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/29 08:29
 * @Version: 1.0
 */
public class Solution20230529 {

    @Test
    public void test() {
        System.out.println(splitArray(new int[]{1, 2, 3, 4, 5}, 2));
    }

    /**
     * 仿照官网写的，动态规划
     * 执行用时：89 ms, 在所有 Java 提交中击败了15%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了40%的用户
     * 通过测试用例：31 / 31
     *
     * @param nums
     * @param k
     * @return
     */
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        // 求前缀和
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        // 定义dp,dp[i][j]表示前i个数分成j组，最小最大分段累加和
        int[][] dp = new int[n + 1][k + 1];
        // 初始化最大值
        for (int[] array : dp) {
            Arrays.fill(array, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                // 定义最后一个分段的最大长度
                int l = i - j + 1;
                for (int m = 1; m <= l; m++) {
                    int number = Math.max(dp[i - m][j - 1], sum[i] - sum[i - m]);
                    dp[i][j] = Math.min(dp[i][j], number);
                }

            }
        }
        return dp[n][k];
    }
}
