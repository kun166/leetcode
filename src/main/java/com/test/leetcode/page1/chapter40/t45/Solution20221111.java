package com.test.leetcode.page1.chapter40.t45;

import org.junit.Test;

public class Solution20221111 {

    @Test
    public void test() {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] >= nums.length - 1) {
                return step + 1;
            }
            // 找到最优的下一个位置，并跳过去
            int fine = 1;
            for (int j = 1; j <= nums[i]; j++) {
                if (fine + nums[fine + i] < j + nums[j + i]) {
                    fine = j;
                }
            }
            step++;
            i = i + fine - 1;
        }
        return step;
    }
}
