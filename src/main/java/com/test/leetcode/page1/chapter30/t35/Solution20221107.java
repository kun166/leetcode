package com.test.leetcode.page1.chapter30.t35;

/**
 * @ClassName: Solution20221107
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/7 19:07
 * @Version: 1.0
 */
public class Solution20221107 {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] >= target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            } else if (nums[right] < target) {
                return right + 1;
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
