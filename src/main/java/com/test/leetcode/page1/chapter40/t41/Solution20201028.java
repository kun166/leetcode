package com.test.leetcode.page1.chapter40.t41;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-28 15:49
 */
public class Solution20201028 {

    @Test
    public void test() {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            if (nums[i] <= length && nums[i] > 0) {
                array[nums[i] - 1] = 1;
            }
        }
        int result = -1;
        for (int i = 0; i < length; i++) {
            if (array[i] != 1) {
                result = i + 1;
                break;
            }
        }
        return result == -1 ? length + 1 : result;
    }
}
