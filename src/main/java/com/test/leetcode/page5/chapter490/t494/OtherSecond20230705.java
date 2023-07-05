package com.test.leetcode.page5.chapter490.t494;

/**
 * @ClassName: OtherSecond20230705
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/5 09:41
 * @Version: 1.0
 */
public class OtherSecond20230705 {

    int ans = 0;

    /**
     * dfs，使用全局变量维护
     *
     * @param nums
     * @param t
     * @return
     */
    public int findTargetSumWays(int[] nums, int t) {
        dfs(nums, t, 0, 0);
        return ans;
    }

    void dfs(int[] nums, int t, int u, int cur) {
        if (u == nums.length) {
            ans += cur == t ? 1 : 0;
            return;
        }
        dfs(nums, t, u + 1, cur + nums[u]);
        dfs(nums, t, u + 1, cur - nums[u]);
    }
}
