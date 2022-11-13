package com.test.leetcode.page1.chapter50.t55;

import org.junit.Test;

/**
 * @ClassName: Solution20221113
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/13 14:33
 * @Version: 1.0
 */
public class Solution2022111301 {

    @Test
    public void test() {
        System.out.println(canJump(new int[]{}));
    }

    /**
     * 这种递归的方式没过，确实太费时间了
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    public boolean canJump(int[] nums, int step) {
        if (step >= nums.length - 1) {
            return true;
        }
        for (int i = 1; i <= nums[step]; i++) {
            if (canJump(nums, step + i)) {
                return true;
            }
        }
        return false;
    }
}
