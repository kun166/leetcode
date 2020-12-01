package com.test.leetcode.chapter80.t84;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-14 15:42
 */
public class Solution {

    @Test
    public void test() {
        int[] heights = new int[]{5, 7, 8, 1, 1, 4, 4, 6, 5, 0, 2};
        System.out.println(largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int maxArea = 0, end = heights.length;
        for (int i = 0; i < heights.length; i++) {
            if (i > end)
                end = heights.length;
            int min = heights[i];
            for (int j = i; j < end; j++) {
                if (heights[j] == 0) {
                    end = j;
                    break;
                }
                min = Math.min(min, heights[j]);
                int area = min * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
