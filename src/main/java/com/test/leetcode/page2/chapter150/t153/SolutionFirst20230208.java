package com.test.leetcode.page2.chapter150.t153;

/**
 * @ClassName: Solution20230208
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 08:20
 * @Version: 1.0
 */
public class SolutionFirst20230208 {

    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n - 1]) {
            return nums[0];
        }
        return findMin(nums, 0, n - 1);
    }

    public int findMin(int[] nums, int start, int end) {
        if (start >= end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        int left, right;
        if (nums[start] <= nums[mid]) {
            // 左侧排好序了
            left = nums[start];
        } else {
            left = findMin(nums, start, mid);
        }
        if (mid + 1 == end) {
            right = nums[end];
        } else if (nums[mid + 1] <= nums[end]) {
            // 右侧排好序了
            right = nums[mid + 1];
        } else {
            right = findMin(nums, mid + 1, end);
        }
        return Math.min(left, right);
    }
}
