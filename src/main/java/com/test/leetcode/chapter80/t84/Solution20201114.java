package com.test.leetcode.chapter80.t84;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-14 16:39
 */
public class Solution20201114 {

    @Test
    public void test() {
        int[] heights = new int[]{5, 7, 8, 1, 1, 4, 4, 6, 5, 0, 2};
        System.out.println(largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        // 先根据高度为0的划分数组
//        Map<Integer, Integer> group = new HashMap<>();
//        int start = -1;
//        for (int i = 0; i < heights.length; i++) {
//            if (heights[i] == 0) {
//                if (start != -1) {
//                    group.put(start, i - 1);
//                }
//                start = -1;
//            } else if (start == -1) {
//                start = i;
//            }
//        }
//        int max = 0;
//        for (Map.Entry<Integer, Integer> entry : group.entrySet()) {
//            int from = entry.getKey(), to = entry.getValue();
//            while (from <= to) {
//
//            }
//        }
        return largestRectangleArea(heights, 0, heights.length - 1);
    }

    public int largestRectangleArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        else if (start == end)
            return heights[start];
        // 找到最小值的坐标
        int minH = start;
        boolean equalsH = true;
        for (int i = start + 1; i <= end; i++) {
            if (heights[i] < heights[minH]) {
                minH = i;
                equalsH = false;
            } else if (equalsH && heights[i] > heights[minH])
                equalsH = false;
        }
        int area = (end - start + 1) * heights[minH];
        if (equalsH)
            return area;
        int la = largestRectangleArea(heights, start, minH - 1);
        int ra = largestRectangleArea(heights, minH + 1, end);
        return Math.max(area, Math.max(la, ra));
    }
}
