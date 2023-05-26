package com.test.leetcode.page5.chapter410.t410;

import java.util.Arrays;

/**
 * @ClassName: OfficialFirst20230526
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/26 09:11
 * @Version: 1.0
 */
public class OfficialFirst20230526 {

    /**
     * 方法一：动态规划
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        // 定义数组长度
        int n = nums.length;
        // f[i][j]表示前i个数字，分成j组，最大和的最小值
        int[][] f = new int[n + 1][m + 1];
        // 对于f[i][j]只有当i>=j的时候才是合法的，当i<j的时候是非法状态。
        // 初始状态，给与一个很大的数，不影响求min
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        // sub[i]表示前i个数的累加和
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    // 求最小值
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }
}
