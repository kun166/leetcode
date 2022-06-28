package com.test.leetcode.page1.chapter10.t11;

import org.junit.Test;

/**
 * @ClassName: Solution20220628
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/28 09:24
 * @Version: 1.0
 */
public class Solution20220628 {

    @Test
    public void test() {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return area;
    }
}
