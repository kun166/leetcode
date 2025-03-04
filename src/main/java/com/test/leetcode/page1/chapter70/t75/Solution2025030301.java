package com.test.leetcode.page1.chapter70.t75;

public class Solution2025030301 {

    /**
     * 来个稍微简单点的,循环两次的吧
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        // 双指针
        int left = -1, right = 0;
        for (; right < nums.length; right++) {
            if (nums[right] == 0)
                swap(nums, ++left, right);
        }
        right = left + 1;
        for (; right < nums.length; right++) {
            if (nums[right] == 1)
                swap(nums, ++left, right);
        }
    }

    public void swap(int[] nums, int left, int right) {
        if (left == right)
            return;
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
