package com.test.leetcode.page2.chapter160.t162;

import org.junit.Test;

/**
 * @ClassName: Solution
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 15:01
 * @Version: 1.0
 */
public class Solution20230208 {

    @Test
    public void test() {
        //System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 1, 0, -1, -2, -3, -4, -5, -6, -7, -8}));
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                // 如果这个mid点是波峰，则返回
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                // mid处于升序端
                left = mid;
            } else {
                // mid处于降序段
                right = mid;
            }
        }
        return nums[left];
    }
}
