package com.test.leetcode.page1.chapter30.t35;

/**
 * @ClassName: Solution20221010
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/10 15:19
 * @Version: 1.0
 */
public class Solution20221010 {

    /**
     * 这个解法，借鉴了34题的官方解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        // 先处理两个边界
        if (nums[0] > target) {
            return 0;
        }
        if (nums[length - 1] < target) {
            return length;
        }
        // 处理数组内部。找到等于target下标，或者i，i满足nums[i]<target且nums[i+1]>target
        int l = 0, r = length - 1, index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }
}
