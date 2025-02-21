package com.test.leetcode.page5.chapter490.t494;

/**
 * @ClassName: OtherFourth20230705
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/5 10:06
 * @Version: 1.0
 */
public class OtherFourth20230705 {

    /**
     * 动态规划，关于解说:https://leetcode.cn/problems/target-sum/solution/gong-shui-san-xie-yi-ti-si-jie-dfs-ji-yi-et5b/
     * <p>
     * 执行用时：9 ms, 在所有 Java 提交中击败了37.81%的用户
     * 内存消耗：42.5 MB, 在所有 Java 提交中击败了7.01%的用户
     * 通过测试用例：140 / 140
     *
     * @param nums
     * @param t
     * @return
     */
    public int findTargetSumWays(int[] nums, int t) {
        int n = nums.length;
        int s = 0;
        for (int i : nums) s += Math.abs(i);
        if (Math.abs(t) > s) return 0;
        // f[i][j] 代表考虑前 i 个数，当前计算结果为 j 的方案数
        // nums的和为s，如果把符号全换成负号，则累加和为-s，因此范围为[-s,s]
        int[][] f = new int[n + 1][2 * s + 1];
        // 因为数组下标不能小于0，所以加了s修正
        f[0][0 + s] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = -s; j <= s; j++) {
                // f[i][j]中的j如果不在[0,2s]中的话，就没必要求了，根本达不到要求
                if ((j - x) + s >= 0) f[i][j + s] += f[i - 1][(j - x) + s];
                if ((j + x) + s <= 2 * s) f[i][j + s] += f[i - 1][(j + x) + s];
            }
        }
        return f[n][t + s];
    }
}
