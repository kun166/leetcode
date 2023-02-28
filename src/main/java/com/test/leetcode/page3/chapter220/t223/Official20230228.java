package com.test.leetcode.page3.chapter220.t223;

/**
 * @ClassName: Official20230228
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/28 12:46
 * @Version: 1.0
 */
public class Official20230228 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1), area2 = (bx2 - bx1) * (by2 - by1);
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1),
                overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlapArea = Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);
        return area1 + area2 - overlapArea;
    }
}
