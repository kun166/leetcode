package com.test.leetcode.page1.chapter40.t45;

import org.junit.Test;

/**
 * @ClassName: Solution20221013
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/13 20:02
 * @Version: 1.0
 */
public class Solution20221013 {

    @Test
    public void test() {
        System.out.println(jump(new int[]{4, 0, 6, 2, 3, 7, 2, 4, 0}));
    }

    /**
     * 没有什么说的，肯定贪心算法
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 目前能跳跃的最长的那个下标
            int index = i + 1;
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (nums[j] + j >= nums[index] + index) {
                    index = j;
                }
                if (i + nums[i] >= nums.length - 1) {
                    return step + 1;
                }
            }
            step++;
            i = index - 1;
        }
        return step;
    }
}
