package com.test.leetcode.page1.chapter20.t27;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-26 17:00
 */
public class Solution20201026 {

    @Test
    public void test() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int size = removeElement(nums, 2);
        for (int i = 0; i < size; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        //双指针法
        int end = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[end] = nums[i];
                end++;
            }
        }
        return end;
    }
}
