package com.test.leetcode.page5.chapter490.t494;

/**
 * @ClassName: OtherFirst20230705
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/5 09:39
 * @Version: 1.0
 */
public class OtherFirst20230705 {

    /**
     * dfs,接收返回值处理
     *
     * @param nums
     * @param t
     * @return
     */
    public int findTargetSumWays(int[] nums, int t) {
        return dfs(nums, t, 0, 0);
    }

    /**
     * @param nums
     * @param t    目标值
     * @param u    当前下标
     * @param cur  当前值
     * @return
     */
    int dfs(int[] nums, int t, int u, int cur) {
        if (u == nums.length) {
            return cur == t ? 1 : 0;
        }
        int left = dfs(nums, t, u + 1, cur + nums[u]);
        int right = dfs(nums, t, u + 1, cur - nums[u]);
        return left + right;
    }
}
