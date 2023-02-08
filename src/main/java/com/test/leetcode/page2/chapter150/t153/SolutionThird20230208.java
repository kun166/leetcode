package com.test.leetcode.page2.chapter150.t153;

/**
 * @ClassName: SolutionThird20230208
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 09:06
 * @Version: 1.0
 */
public class SolutionThird20230208 {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                if (nums[mid + 1] <= nums[right]) {
                    return nums[mid + 1];
                }
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
