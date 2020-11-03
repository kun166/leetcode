package com.test.leetcode.chapter30.t31;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-27 11:27
 */
public class Solution20201027 {

    @Test
    public void test() {
        int[] nums = {5, 1, 1};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + "->");
        }
    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length <= 1)
            return;
        int index = length - 2;
        // 先找到位置
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }

        if (index == -1) {
            //翻转就可以了
            turnOff(nums, 0, length - 1);
        } else {
            for (int i = length - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    int mid = nums[index];
                    nums[index] = nums[i];
                    nums[i] = mid;
                    break;
                }
            }
            turnOff(nums, index + 1, length - 1);
        }
    }

    public void turnOff(int[] nums, int start, int end) {
        while (start < end) {
            int mid = nums[start];
            nums[start] = nums[end];
            nums[end] = mid;
            start++;
            end--;
        }
    }
}
