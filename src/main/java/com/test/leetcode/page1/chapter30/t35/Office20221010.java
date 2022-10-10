package com.test.leetcode.page1.chapter30.t35;

/**
 * @ClassName: Office20221010
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/10 15:41
 * @Version: 1.0
 */
public class Office20221010 {

    /**
     * 官方解法，更简洁
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
