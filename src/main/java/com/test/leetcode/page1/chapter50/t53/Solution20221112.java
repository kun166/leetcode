package com.test.leetcode.page1.chapter50.t53;

/**
 * @ClassName: Solution20221112
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/12 16:10
 * @Version: 1.0
 */
public class Solution20221112 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sub = 0;
        for (int number : nums) {
            sub += number;
            max = Math.max(max, sub);
            if (sub < 0) {
                sub = 0;
            }
        }
        return max;
    }
}
