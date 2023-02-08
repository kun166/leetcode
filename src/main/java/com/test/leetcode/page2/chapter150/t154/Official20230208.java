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
                // 从pivot到high已经排好序了，最小值要么是nums[pivot],要么在low到pivot-1里
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                // pivot到high未排好序，则最小值，一定在未排好序的这一段里
                low = pivot + 1;
            } else {
                // 重复值,没法二分了，只能慢慢的—1了
                high -= 1;
            }
        }
        return nums[low];
    }
}
