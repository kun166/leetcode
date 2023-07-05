package com.test.leetcode.page5.chapter490.t494;

/**
 * @ClassName: Solution20230705
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/5 09:04
 * @Version: 1.0
 */
public class Solution20230705 {

    private int ans = 0;

    /**
     * 执行用时：498 ms, 在所有 Java 提交中击败了25.62%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了93.19%的用户
     * 通过测试用例：140 / 140
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        findTargetSumWays(nums, target, 0);
        return ans;
    }

    public void findTargetSumWays(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                ans++;
            }
            return;
        }
        findTargetSumWays(nums, target - nums[index], index + 1);
        findTargetSumWays(nums, target + nums[index], index + 1);
    }
}
