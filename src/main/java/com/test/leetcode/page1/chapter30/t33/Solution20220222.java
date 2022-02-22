package com.test.leetcode.page1.chapter30.t33;

import org.junit.Test;

/**
 * @ClassName: Solution20220222
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/2/22 16:02
 * @Version: 1.0
 */
public class Solution20220222 {

    @Test
    public void test() {
        System.out.println(search(new int[]{3, 5, 1}, 3));
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start == end && nums[start] != target) {
            return -1;
        }
        if (nums[start] < nums[end]) {
            // 说明是一个排好序的数组
            if (nums[start] > target || nums[end] < target) {
                return -1;
            }
            // 二分法
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return search(nums, target, start, mid);
            }
            return search(nums, target, mid + 1, end);
        } else {
            // 说明是非排序好的，直接二分法
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                // 说明排好序了
                if (nums[start] <= target && nums[mid] > target) {
                    return search(nums, target, start, mid);
                }
                return search(nums, target, mid + 1, end);
            } else {
                if (nums[mid] < target && nums[end] >= target) {
                    return search(nums, target, mid + 1, end);
                }
                return search(nums, target, start, mid);
            }
        }
    }
}
