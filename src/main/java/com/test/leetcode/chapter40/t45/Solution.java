package com.test.leetcode.chapter40.t45;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-28 20:16
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 1, 1, 4, 1};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums) {
        int length = nums.length;
        if (length == 1) return 0;
        int setp = 0;
        for (int i = 0; i < length; i++) {
            if (i + nums[i] + 1 >= length) return setp + 1;
            int max = 0, cur = 0;
            for (int j = i + 1; j < length && j <= i + nums[i]; j++) {
                if (j - i + nums[j] > max) {
                    max = j - i + nums[j];
                    cur = j;
                }
            }
            setp++;
            i = cur - 1;
        }
        return setp;
    }
}
