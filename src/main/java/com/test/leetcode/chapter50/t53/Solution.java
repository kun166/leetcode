package com.test.leetcode.chapter50.t53;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-03 20:25
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
