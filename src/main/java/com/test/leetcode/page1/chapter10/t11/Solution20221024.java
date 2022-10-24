package com.test.leetcode.page1.chapter10.t11;

/**
 * @ClassName: Solution20221024
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/24 10:27
 * @Version: 1.0
 */
public class Solution20221024 {

    public int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int area;
            if (height[l] > height[r]) {
                area = height[r] * (r - l);
                r--;
            } else {
                area = height[l] * (r - l);
                l++;
            }
            max = Math.max(max, area);
        }
        return max;
    }
}
