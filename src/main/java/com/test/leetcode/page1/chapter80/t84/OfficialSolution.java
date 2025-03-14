package com.test.leetcode.page1.chapter80.t84;

import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-14 18:00
 */
public class OfficialSolution {

    /**
     * 这种方式,不是面试的时候想出来的
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 存放左侧小于自己的坐标
        int[] left = new int[n];
        // 存放右侧小于自己的坐标
        int[] right = new int[n];

        //单调栈(单调递增或者单调递减)
        // 存放的是坐标
        Stack<Integer> mono_stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            // 从左向右遍历。
            // 单调递增
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
