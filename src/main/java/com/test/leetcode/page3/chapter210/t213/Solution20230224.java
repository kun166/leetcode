package com.test.leetcode.page3.chapter210.t213;

import org.junit.Test;

/**
 * @ClassName: Solution20230224
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/24 10:30
 * @Version: 1.0
 */
public class Solution20230224 {

    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 2, 3, 1, 2, 5, 7}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (n == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        // 第一个房间偷了且当前房间偷了
        // 第一个房间偷了且当前房间没偷
        // 第一个房间没偷且当前房间偷了
        // 第一个房间没偷且当前也没偷
        int f1 = nums[0] + nums[2], f2 = nums[0], f3 = nums[2], f4 = nums[1];
        for (int i = 3; i < n - 1; i++) {
            int cf1 = f2 + nums[i];
            f2 = Math.max(f1, f2);
            f1 = cf1;

            int cf3 = f4 + nums[i];
            f4 = Math.max(f3, f4);
            f3 = cf3;
        }
        return Math.max(Math.max(f1, f2), Math.max(f3, f4 + nums[n - 1]));
    }
}
