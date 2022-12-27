package com.test.leetcode.page1.chapter80.t84;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20221226
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/26 19:07
 * @Version: 1.0
 */
public class Solution20221226 {

    @Test
    public void test() {
        //System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{5, 5, 5, 5, 5, 5}));
    }

    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                deque.pop();
            }
            left[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(i);
        }

        deque.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                deque.pop();
            }
            right[i] = deque.isEmpty() ? heights.length : deque.peek();
            deque.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (heights[i] * (right[i] - left[i] - 1)));
        }
        return maxArea;
    }
}
