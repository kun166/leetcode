package com.test.leetcode.page1.chapter40.t45;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution2025022502
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/25 09:55
 * @Version: 1.0
 */
public class Solution2025022502 {

    @Test
    public void test() {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    /**
     * 动态规划试试
     * <p>
     * 280ms，击败了5%的人……
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, length);
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    // 说明能达到这个位置
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[length - 1];
    }
}
