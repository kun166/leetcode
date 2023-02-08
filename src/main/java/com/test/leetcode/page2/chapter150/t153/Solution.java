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
        System.out.println(findMin(new int[]{4, 5, 6, 0, 1, 2}));
    }

    /**
     * 这个思路，我感觉更好啊。
     * 最小值，存在在两个地方
     * 1,折点处,此时折点所在的数组段是非排好序的。也即如果从start到mid，mid+1到end,
     * 只要有一个是非排好序的，则最小值肯定在非排好序的这段里。
     * 2,如果两个段都已经排好序了，那最小值肯定nums[mid+1]
     *
     * @param nums
     * @return
     */
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
