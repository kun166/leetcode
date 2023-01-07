package com.test.leetcode.page1.chapter90.t96;

import org.junit.Test;

/**
 * @ClassName: Solution20230107
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/7 11:47
 * @Version: 1.0
 */
public class Solution20230107 {

    @Test
    public void test() {
        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
    }

    /**
     * 这题又是个动态规划题目
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        // dp[n]表示有n个节点的时候，能组成的树的数目
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // j表示以j为root,则左侧有j-1个节点，右侧有i-j个节点
                // 特别的当j为1的时候，左侧有0个节点，因为需要有乘积，也设置dp[0]=1;
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
