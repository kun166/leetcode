package com.test.leetcode.page1.chapter30.t34;

import org.junit.Test;

/**
 * @ClassName: Solution20250221
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/21 10:02
 * @Version: 1.0
 */
public class Solution20250221 {

    @Test
    public void test() {
        int[] nums = {1, 4};
        System.out.println(searchRange(nums, 4, 0, nums.length - 1, true));
    }

    /**
     * 这题无语了，提交好多次都失败了，哭了,这一版本也是错的……
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        return new int[]{
                searchRange(nums, target, 0, nums.length - 1, false),
                searchRange(nums, target, 0, nums.length - 1, true)
        };
    }

    /**
     * 查找下标
     *
     * @param nums     数组
     * @param target   目标值
     * @param left     左侧坐标
     * @param right    右侧坐标
     * @param fromLeft 从左向右，即找最右侧的那个值。如果是false，就是找最左侧的那个值
     * @return
     */
    public int searchRange(int[] nums, int target, int left, int right, boolean fromLeft) {
        if (nums[left] > target || nums[right] < target) {
            return -1;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (left == mid) {
                if (nums[left] != target && nums[right] != target) {
                    return -1;
                } else if (nums[left] == target && nums[right] == target) {
                    return fromLeft ? right : left;
                } else if (nums[left] == target) {
                    return left;
                }
                return right;
            }
            if (nums[mid] == target) {
                if (fromLeft)
                    // 找右边最大
                    left = mid;
                else
                    right = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
