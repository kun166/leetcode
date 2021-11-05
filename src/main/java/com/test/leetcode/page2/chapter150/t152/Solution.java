package com.test.leetcode.page2.chapter150.t152;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-04 15:25
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        ans = nums[0];
        int start = nums[0] == 0 ? 1 : 0;
        // 1是正序,2是逆序,3是无序
        int type = 3;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, nums[i]);
            if (nums[i] == 0) {
                // 计算前面的子数组
                ans = Math.max(ans, compute(nums, start, i - 1));
                start = i + 1;
                continue;
            }
            // 先找连续子数组
            if (nums[i] == nums[i - 1] + 1) {
                if (type == 3) {
                    type = 1;
                } else if (type == 2) {
                    //乱序了，计算最大值
                    ans = Math.max(ans, compute(nums, start, i - 1));
                    type = 1;
                    start = i - 1;
                }
            } else if (nums[i] == nums[i - 1] - 1) {
                if (type == 3) {
                    type = 2;
                } else if (type == 1) {
                    //乱序了，计算最大值
                    ans = Math.max(ans, compute(nums, start, i - 1));
                    type = 2;
                    start = i - 1;
                }
            } else {
                ans = Math.max(ans, compute(nums, start, i - 1));
                type = 3;
                start = i;
            }
        }
        return ans;
    }

    public int compute(int[] nums, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        if (start == end) {
            return nums[start];
        }
        int value = 1;
        for (int i = start; i <= end; i++) {
            value *= nums[i];
        }
        if (value < 0) {
            return Math.max(value / nums[start], value / nums[end]);
        }
        return value;
    }
}
