package com.test.leetcode.page6.chapter540.t540;

/**
 * @ClassName: Solution20230830
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/30 15:29
 * @Version: 1.0
 */
public class Solution20230830 {

    /**
     * 0ms
     * 击败 100.00%使用 Java 的用户
     * 46.25MB
     * 击败 83.12%使用 Java 的用户
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        // 二分查找法
        int left = 0, right = length - 1;
        while (left <= right) {
            if (left == right) {
                return nums[left];
            }
            // 二分
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid - 1]) {
                // 和左侧相等
                if ((mid - left + 1) % 2 == 0) {
                    // 左侧偶数个元素
                    left = mid + 1;
                } else {
                    right = mid - 2;
                }

            } else if (nums[mid] == nums[mid + 1]) {
                // 和右侧相等
                if ((right - mid + 1) % 2 == 0) {
                    // 右侧偶数个
                    right = mid - 1;
                } else {
                    left = mid + 2;
                }
            } else {
                return nums[mid];
            }
        }
        return -1;
    }
}
