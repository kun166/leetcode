package com.test.leetcode.chapter20.t26;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-26 16:36
 */
public class Solution20201026 {

    @Test
    public void test() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int size = removeDuplicates(nums);
        for (int i = 0; i < size; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 1)
            return length;
        //双指针法
        int end = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (i != end) {
                    // 移动数组。将i位置的移动到end位置
                    nums[end] = nums[i];
                }
                end++;
            }
        }
        return end;
    }
}
