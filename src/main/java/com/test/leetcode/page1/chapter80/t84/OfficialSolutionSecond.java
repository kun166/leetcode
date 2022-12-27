package com.test.leetcode.page1.chapter80.t84;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-25 19:48
 */
public class OfficialSolutionSecond {

    @Test
    public void test(){
        System.out.println(largestRectangleArea(new int[]{5, 5, 5, 5, 5, 5}));
    }

    /**
     * 这种方式的left和right的值，对于数组{5, 5, 5, 5, 5, 5}，和上一种方式，是不一样的
     * 虽然结果相同
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
