package com.test.leetcode.page3.chapter280.t287;

/**
 * @ClassName: Solution20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 17:27
 * @Version: 1.0
 */
public class Solution20230331 {

    /**
     * 这个解法不对，因为不连续，可能有缺失
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // 寻找最大值
        int n = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            n = Math.max(n, nums[i]);
        }
        return (sum - (1 + n) * n / 2) / (nums.length - n);
    }
}
