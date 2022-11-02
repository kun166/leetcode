package com.test.leetcode.page1.chapter30.t34;

/**
 * @ClassName: Solution20221102
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/2 08:54
 * @Version: 1.0
 */
public class Solution20221102 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchRangeLeft(nums, target), searchRangeRight(nums, target)};
    }

    public int searchRangeLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == target) {
                return left;
            }
            int mid = left + (right - left) / 2;
            if (mid == left) {
                if (nums[right] == target) {
                    return right;
                }
                return -1;
            }
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int searchRangeRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[right] == target) {
                return right;
            }
            int mid = left + (right - left) / 2;
            if (mid == left) {
                if (nums[left] == target) {
                    return left;
                }
                return -1;
            }
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
