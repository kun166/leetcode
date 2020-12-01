package com.test.leetcode.chapter80.t84;

import org.junit.Test;

import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-25 19:09
 */
public class Solution20201125 {

    @Test
    public void test() {
        //int[] heights = new int[]{5, 7, 8, 1, 1, 4, 4, 6, 5, 0, 2};
        int[] heights = new int[]{1};
        System.out.println(largestRectangleArea(heights));
    }


    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (right[i] - left[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
