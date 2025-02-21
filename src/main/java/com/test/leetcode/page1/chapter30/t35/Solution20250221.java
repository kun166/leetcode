package com.test.leetcode.page1.chapter30.t35;

/**
 * @ClassName: Solution20250221
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/21 11:01
 * @Version: 1.0
 */
public class Solution20250221 {

    /**
     * 不用想了，肯定双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (nums[0] >= target) {
            return 0;
        } else if (nums[length - 1] == target) {
            return length - 1;
        } else if (nums[length - 1] < target) {
            return length;
        }

        int left = 0, right = length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid == left) {
                return right;
            }
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left + 1;
    }
}
