package com.test.leetcode.page3.chapter220.t223;

/**
 * @ClassName: Official20230228
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/28 11:23
 * @Version: 1.0
 */
public class Solution20230228 {

    /**
     * 呃，这题感觉是几何题啊……
     *
     * @param ax1
     * @param ay1
     * @param ax2
     * @param ay2
     * @param bx1
     * @param by1
     * @param bx2
     * @param by2
     * @return
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 可以通过两个点，确认x和y的区间
        // 如何判断两个长方形相交？
        // 不相交的情况,x轴不想交或者y轴相交

        if (ax1 >= bx2 || ax2 <= bx1 || ay1 >= by2 || ay2 <= by1) {
            // 不想交，返回两个面积之和
            return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        }
        // 相交
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1)
                - (Math.min(ax2, bx2) - Math.max(ax1, bx1)) * (Math.min(ay2, by2) - Math.max(ay1, by1));
    }
}
