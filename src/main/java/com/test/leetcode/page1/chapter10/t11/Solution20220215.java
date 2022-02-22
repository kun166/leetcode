package com.test.leetcode.page1.chapter10.t11;

import org.junit.Test;

/**
 * @ClassName: Solution20220215
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/2/15 16:24
 * @Version: 1.0
 */
public class Solution20220215 {

    @Test
    public void test() {
        maxArea(new int[]{2, 3, 4, 5, 18, 17, 6});
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
