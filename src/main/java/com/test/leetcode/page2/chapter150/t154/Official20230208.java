package com.test.leetcode.page2.chapter150.t154;

/**
 * @ClassName: Official20230208
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 09:23
 * @Version: 1.0
 */
public class Official20230208 {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
}
