package com.test.leetcode.page2.chapter150.t152;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-04 16:03
 */
public class SolutionFirst {

    @Test
    public void test() {
        System.out.println(maxProduct(new int[]{2, -5, -2, -4, 3}));
    }

    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int lStart = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, nums[i]);
            if (nums[i] == 0) {
                // 计算以前最大值
                ans = Math.max(ans, computer(nums, lStart, i - 1));
                lStart = i + 1;
            }
        }
        ans = Math.max(ans, computer(nums, lStart, nums.length - 1));
        // 计算最大值
        return ans;
    }

    public int computer(int[] nums, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        if (start == end) {
            return nums[start];
        }
        int lIndex = -1;
        int lValue = 1;
        for (int i = start; i <= end; i++) {
            if (nums[i] < 0) {
                lIndex = i;
                break;
            }
            lValue *= nums[i];
        }
        if (lIndex == -1) {
            return lValue;
        }
        int rIndex = nums.length;
        int rValue = 1;
        for (int i = end; i >= start; i--) {
            if (nums[i] < 0) {
                rIndex = i;
                break;
            }
            rValue *= nums[i];
        }
        if (lIndex == rIndex) {
            return Math.max(lValue, rValue);
        }

        int mValue = 1;
        for (int i = lIndex + 1; i < rIndex; i++) {
            mValue *= nums[i];
        }

        if (mValue > 0) {
            return mValue * rValue * lValue * nums[lIndex] * nums[rIndex];
        } else {
            lValue *= nums[lIndex];
            rValue *= nums[rIndex];
            if (lValue > rValue) {
                return mValue * rValue;
            }
            return mValue * lValue;
        }
    }
}
