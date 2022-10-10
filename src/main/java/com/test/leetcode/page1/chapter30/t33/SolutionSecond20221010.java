package com.test.leetcode.page1.chapter30.t33;

import org.junit.Test;

/**
 * @ClassName: SolutionSecond20221010
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/10 10:25
 * @Version: 1.0
 */
public class SolutionSecond20221010 {
    @Test
    public void test() {
        System.out.println(search(new int[]{3, 1}, 1));
    }

    /**
     * 官网的解法更清爽
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        while (start < end) {
            // 找中间位置
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[start]) {
                // 左边连续
                if (nums[start] <= target && nums[mid] > target) {
                    return search(nums, target, start, mid - 1);
                } else {
                    return search(nums, target, mid + 1, end);
                }
            } else {
                // 右边连续
                if (nums[mid] < target && nums[end] >= target) {
                    return search(nums, target, mid + 1, end);
                } else {
                    return search(nums, target, start, mid - 1);
                }
            }
        }
        return nums[start] == target ? start : -1;
    }
}
