package com.test.leetcode.page1.chapter80.t84;

import java.util.LinkedList;

/**
 * @ClassName: Solution2025030601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/6 08:42
 * @Version: 1.0
 */
public class Solution2025030601 {

    /**
     * 昨天做的两次都超时了,看了题解，确实自己思路很有问题……
     * <p>
     * 这题要么以宽度遍历，要么以高度遍历……,自己的思路那是啥？
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        // 坐标,左边比自己低的那个下标
        int[] left = new int[n];
        // 右边比自己低的那个下标
        int[] right = new int[n];
        // 单调栈
        LinkedList<Integer> ll = new LinkedList();
        // 利用单调栈初始化left
        for (int i = 0; i < n; i++) {
            while (!ll.isEmpty() && heights[i] <= heights[ll.peek()])
                // 单调递增栈。如果单调栈不空,且top记录的下标的高不低于当前下标的高度,则弹出栈
                // 为什么用<=?因为左边和自己等高的也要计算进来
                ll.pop();
            // 找到左边第一个比自己低的那个下标
            left[i] = ll.isEmpty() ? -1 : ll.peek();
            // 当前坐标是栈里最高的那个了
            ll.push(i);
        }

        // 利用单调栈初始化right。和上面一样
        ll.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!ll.isEmpty() && heights[i] <= heights[ll.peek()])
                ll.pop();
            right[i] = ll.isEmpty() ? heights.length : ll.peek();
            ll.push(i);
        }

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * heights[i]);
        }
        return maxArea;
    }
}
