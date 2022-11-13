package com.test.leetcode.page1.chapter50.t55;

/**
 * @ClassName: Solution2022111302
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/13 15:47
 * @Version: 1.0
 */
public class Solution2022111302 {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && max <= 1 && i < nums.length - 1) {
                return false;
            }
            max = Math.max(max - 1, nums[i]);
        }
        return true;
    }
}
