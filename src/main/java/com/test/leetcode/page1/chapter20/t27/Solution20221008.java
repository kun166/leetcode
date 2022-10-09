package com.test.leetcode.page1.chapter20.t27;

/**
 * @ClassName: Solution20221008
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/8 17:42
 * @Version: 1.0
 */
public class Solution20221008 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int number : nums) {
            if (number == val) {
                continue;
            }
            nums[index++] = number;
        }
        return index;
    }
}
