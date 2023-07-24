package com.test.leetcode.page3.chapter270.t279;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution20230721
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/21 10:57
 * @Version: 1.0
 */
public class Solution20230721 {

    @Test
    public void test() {
        System.out.println(numSquares(13));
    }

    /**
     * 执行用时：45 ms, 在所有 Java 提交中击败了37.92%的用户
     * 内存消耗：40.6 MB, 在所有 Java 提交中击败了56.08%的用户
     * 通过测试用例：588 / 588
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
