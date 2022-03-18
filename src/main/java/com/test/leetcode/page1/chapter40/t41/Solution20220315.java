package com.test.leetcode.page1.chapter40.t41;

/**
 * @ClassName: Solution20220315
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/15 16:43
 * @Version: 1.0
 */
public class Solution20220315 {

    public int firstMissingPositive(int[] nums) {
        boolean[] array = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                array[nums[i] - 1] = true;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (!array[i]) {
                return i + 1;
            }
        }
        return array.length + 1;
    }
}
