package com.test.leetcode.page1.chapter40.t42;

import org.junit.Test;

public class Solution2022111102 {

    @Test
    public void test() {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1, area = 0, maxLeft = 0, maxRight = 0;
        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (height[left] < height[right]) {
                area += Math.min(maxLeft, maxRight) - height[left];
                left++;
            } else {
                area += Math.min(maxLeft, maxRight) - height[right];
                right--;
            }
        }
        return area;
    }
}
