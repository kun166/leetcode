package com.test.leetcode.page2.chapter150.t153;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-04 19:53
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int start, int end) {
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        if (mid > start && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
        if (nums[start] > nums[mid]) {
            return findMin(nums, start, mid);
        }
        return findMin(nums, mid + 1, end);
    }
}
