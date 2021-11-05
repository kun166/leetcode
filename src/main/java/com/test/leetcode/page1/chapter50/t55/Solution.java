package com.test.leetcode.page1.chapter50.t55;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-05 16:52
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(canJump(new int[]{1, 1, 0, 1}));
    }

    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    /**
     * 递归
     *
     * @param nums
     * @param index
     * @return
     */
    public boolean canJump(int[] nums, int index) {
        if (index + nums[index] + 1 >= nums.length) {
            return true;
        }
        boolean pass = nums[index + nums[index]] != 0;

        for (int i = 1; i <= nums[index]; i++) {
            pass = pass || canJump(nums, index + i);
        }
        return pass ? canJump(nums, index + nums[index]) : false;
    }
}
