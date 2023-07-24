package com.test.leetcode.dp;

import org.junit.Test;

/**
 * @ClassName: Package20230721
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/21 09:32
 * @Version: 1.0
 */
public class Package20230721 {

    @Test
    public void test() {
        System.out.println(maxValue(2,5,new int[]{1,2},new int[]{1,2}));
    }

    /**
     * 完全背包
     *
     * @param n 物品数量
     * @param c 背包容量
     * @param v 物品价值数组
     * @param w 物品体积数组
     * @return
     */
    public int maxValue(int n, int c, int[] v, int[] w) {
        int[] dp = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= w[j]) {
                    dp[i] = Math.max(dp[i], dp[i - w[j]] + v[j]);
                }
            }
        }
        return dp[c];
    }
}
