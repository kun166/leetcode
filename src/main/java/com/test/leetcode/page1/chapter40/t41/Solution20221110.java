package com.test.leetcode.page1.chapter40.t41;

import org.junit.Test;

/**
 * @ClassName: Solution20221110
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/10 19:39
 * @Version: 1.0
 */
public class Solution20221110 {

    @Test
    public void test() {
        System.out.println(firstMissingPositive(new int[]{1, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
            nums[i] = -nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
