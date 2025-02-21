package com.test.leetcode.page5.chapter490.t494;

/**
 * @ClassName: OtherFifth20230705
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/5 10:16
 * @Version: 1.0
 */
public class OtherFifth20230705 {

    /**
     * 动态规划（优化）
     *
     * @param nums
     * @param t
     * @return
     */
    public int findTargetSumWays(int[] nums, int t) {
        int n = nums.length;
        int s = 0;
        for (int i : nums) s += Math.abs(i);
        if (t > s || (s - t) % 2 != 0) return 0;
        int m = (s - t) / 2;
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = 0; j <= m; j++) {
                f[i][j] += f[i - 1][j];
                if (j >= x) f[i][j] += f[i - 1][j - x];
            }
        }
        return f[n][m];
    }

}
