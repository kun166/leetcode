package com.test.leetcode.page1.chapter30.t34;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-28 10:43
 */
public class Solution201028 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        nums = searchRange(nums, 2);
        for (int i : nums) {
            System.out.print(i + "->");
        }
    }


    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0 || nums[0] > target || nums[length - 1] < target)
            return new int[]{-1, -1};
        int start = 0, end = length - 1;
        // 先二分法查到这个元素吧。
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (index == -1)
            return new int[]{-1, -1};
        // 找左侧的点
        int left;
        if (nums[index] != nums[0]) {
            left = index;
            start = 0;
            while (start < left) {
                int mid = start + (left - start) / 2;
                if (nums[mid] == target)
                    left = mid;
                else
                    start = mid + 1;
            }
        } else {
            left = 0;
        }
        // 找右侧的点
        int right;
        if (nums[index] != nums[length - 1]) {
            right = index;
            end = length - 1;
            while (right < end) {
                int mid = end - (end - right) / 2;
                if (nums[mid] == target)
                    right = mid;
                else
                    end = mid - 1;
            }
        } else {
            right = length - 1;
        }

        return new int[]{left, right};
    }
}
