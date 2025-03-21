package com.test.leetcode.page2.chapter150.t152;

/**
 * @ClassName: Solution2025032101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/21 14:24
 * @Version: 1.0
 */
public class Solution2025032101 {

    /**
     * 这题没思路，瞎写一个……
     * <p>
     * 0ms	击败100.00%
     * 44.19MB	击败8.62%
     * <p>
     * 呃,呃,呃,居然过了……
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int total = 1;
        // 从左向右
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, nums[i]);
            if (nums[i] == 0) {
                total = 1;
            } else {
                total *= nums[i];
                ans = Math.max(ans, total);
            }
        }
        // 从右向左
        total = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                total = 1;
            } else {
                total *= nums[i];
                ans = Math.max(ans, total);
            }
        }
        return ans;
    }
}
