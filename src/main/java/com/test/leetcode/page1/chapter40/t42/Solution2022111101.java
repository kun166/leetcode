package com.test.leetcode.page1.chapter40.t42;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2022111101 {

    @Test
    public void test() {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * 单调栈
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        int area = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[deque.peek()] > height[i]) {
                deque.push(i);
                continue;
            }
            // 找到比它大的节点
            while (!deque.isEmpty() && height[deque.peek()] <= height[i]) {
                int j = deque.pop();
                if (!deque.isEmpty()) {
                    area += (i - deque.peek() - 1) * (Math.min(height[deque.peek()], height[i]) - height[j]);
                }
            }
            deque.push(i);
        }
        return area;
    }
}
