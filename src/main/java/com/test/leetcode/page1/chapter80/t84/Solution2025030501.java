package com.test.leetcode.page1.chapter80.t84;

/**
 * @ClassName: Solution2025030501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/5 16:15
 * @Version: 1.0
 */
public class Solution2025030501 {

    /**
     * 先自行尝试下吧
     * <p>
     * 超出时间限制……好吧
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        // 1,先根据0分段
        int maxArea = 0;
        int pl = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == 0) {
                maxArea = Math.max(maxArea, largestRectangleArea(heights, pl, i));
                pl = i + 1;
            }
        }
        maxArea = Math.max(maxArea, largestRectangleArea(heights, pl, heights.length - 1));
        return maxArea;
    }


    public int largestRectangleArea(int[] heights, int pl, int pr) {
        int maxArea = 0, left, right, minHeight;
        for (int i = pl; i <= pr; i++) {
            left = right = i;
            minHeight = heights[i];
            while (left > pl && right < pr) {
                maxArea = Math.max(maxArea, minHeight * (right - left + 1));
                if (heights[left - 1] > heights[right + 1]) {
                    // 挑选高的那个
                    minHeight = Math.min(minHeight, heights[--left]);
                } else {
                    minHeight = Math.min(minHeight, heights[++right]);
                }

            }
            while (left > pl) {
                maxArea = Math.max(maxArea, minHeight * (right - left + 1));
                minHeight = Math.min(minHeight, heights[--left]);
            }
            while (right < pr) {
                maxArea = Math.max(maxArea, minHeight * (right - left + 1));
                minHeight = Math.min(minHeight, heights[++right]);
            }
            maxArea = Math.max(maxArea, minHeight * (right - left + 1));
        }
        return maxArea;
    }

}
