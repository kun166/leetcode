package com.test.leetcode.page1.chapter30.t33;

/**
 * @ClassName: Solution20250221
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/21 09:22
 * @Version: 1.0
 */
public class Solution20250221 {

    /**
     * 这个简单的地方在于数组内的数字均不同
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return -1;
        }
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int left, int right) {
        if (nums[left] == target)
            return left;
        else if (nums[right] == target)
            return right;
        else if (left + 1 >= right) {
            return -1;
        }
        // 这个地方可以加一个判断，是否是升序排列，如果是，则直接可以是否返回-1
        int mid = left + (right - left) / 2;
        if (nums[left] < nums[mid]) {
            // 左侧顺序排列
            if (nums[left] <= target && nums[mid] >= target) {
                return search(nums, target, left, mid);
            }
            return search(nums, target, mid + 1, right);
        }
        // 右侧顺序排列
        if (nums[right] >= target && nums[mid] <= target) {
            return search(nums, target, mid, right);
        }
        return search(nums, target, left, mid - 1);
    }
}
