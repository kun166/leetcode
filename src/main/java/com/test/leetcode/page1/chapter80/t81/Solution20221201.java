package com.test.leetcode.page1.chapter80.t81;

import org.junit.Test;

/**
 * @ClassName: Solution20221201
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/1 09:23
 * @Version: 1.0
 */
public class Solution20221201 {

    @Test
    public void test() {
        System.out.println(search(new int[]{1, 0, 1, 1, 1}, 0));
    }

    /**
     * 1,非递降
     * 2,某个未知位置扭转
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (nums[left] == nums[right] && left < right) {
                right--;
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] <= nums[mid]) {
                // 从left到mid是有序的
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 从mid到right是有序的
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return false;
    }
}
