package com.test.leetcode.page3.chapter280.t283;

/**
 * @ClassName: Solution20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 08:54
 * @Version: 1.0
 */
public class Solution20230331 {

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        for (; right < n; right++) {
            if (nums[right] == 0)
                continue;
            nums[left++] = nums[right];
        }
        for (; left < n; left++) {
            nums[left] = 0;
        }
    }
}
