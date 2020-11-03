package com.test.leetcode.chapter30.t33;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-27 19:46
 */
public class Solution20201027 {

    @Test
    public void test() {
        System.out.println(harfSearch(new int[]{1, 2, 3, 4, 5}, 5, 0, 4));
    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0 || (nums[0] > target))
            return -1;
        // 折半二分
        return -1;
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start > end || (nums[end] < target && nums[start] > target))
            return -1;
        // 折半二分
        int mid = start + (end - start) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > target) {
            // 中位数比查找的数大。
            if (nums[mid] >= nums[start]) {

            }
        } else {

        }
        return -1;
    }

    /**
     * 折半查找法。(已经排好序)
     *
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */
    public int harfSearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        // 折半二分
        int mid = start + (end - start) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > target) {
            return harfSearch(nums, target, start, mid - 1);
        }
        return harfSearch(nums, target, mid + 1, end);
    }


}
