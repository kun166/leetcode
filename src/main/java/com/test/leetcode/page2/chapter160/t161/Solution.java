package com.test.leetcode.page2.chapter160.t161;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-05 17:46
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else {
                if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                    return i;
                }
            }
        }
        return -1;
    }
}
