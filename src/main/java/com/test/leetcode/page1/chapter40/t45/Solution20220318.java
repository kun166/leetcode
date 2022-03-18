package com.test.leetcode.page1.chapter40.t45;

import org.junit.Test;

/**
 * @ClassName: Solution20220318
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/18 14:59
 * @Version: 1.0
 */
public class Solution20220318 {

    @Test
    public void test() {
        System.out.println(jump(new int[]{2, 3, 1, 2, 4, 2, 3}));
    }

    public int jump(int[] nums) {
        // 贪心算法
        int count = 0;
        int current = 0;
        while (current < nums.length - 1) {
            current = jump(nums, current);
            count++;
        }
        return count;
    }

    /**
     * 返回跳到哪一个位置，最远
     *
     * @param nums    跳跃数组
     * @param current 当前所在位置
     * @return
     */
    public int jump(int[] nums, int current) {
        int step = 0;
        int max = 0;
        for (int i = 1; i <= nums[current]; i++) {
            if (current + i >= nums.length - 1) {
                return current + i;
            }
            if (i + nums[current + i] > max) {
                max = i + nums[current + i];
                step = current + i;
            }
        }
        return step;
    }

}
