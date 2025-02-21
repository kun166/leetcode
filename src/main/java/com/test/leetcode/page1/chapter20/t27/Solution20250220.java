package com.test.leetcode.page1.chapter20.t27;

/**
 * @ClassName: Solution20250220
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/20 11:27
 * @Version: 1.0
 */
public class Solution20250220 {

    /**
     * 这个也肯定双指针了
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++left] = nums[i];
            }
        }
        return left + 1;
    }
}
