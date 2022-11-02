package com.test.leetcode.page1.chapter30.t33;

import org.junit.Test;

/**
 * @ClassName: Solution20221101
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/1 20:10
 * @Version: 1.0
 */
public class Solution20221101 {

    @Test
    public void test() {
        System.out.println(search(new int[]{3, 1}, 1));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                // 从left到mid是顺序的
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 从mid 到right是顺序的
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
