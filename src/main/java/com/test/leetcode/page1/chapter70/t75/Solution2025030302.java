package com.test.leetcode.page1.chapter70.t75;

public class Solution2025030302 {

    /**
     * 仅使用常数空间的一趟扫描算法
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        // 这个其实只需要定义好0和2的位置就好，中间的就是1……
        int left = -1, right = nums.length;
        for (int i = 0; i < right; ) {
            if (nums[i] == 0) {
                swap(nums, ++left, i++);
            } else if (nums[i] == 2)
                swap(nums, i, --right);
            else
                i++;
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
