package com.test.leetcode.page3.chapter220.t223;

/**
 * @ClassName: Solution2025040101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 14:49
 * @Version: 1.0
 */
public class Solution2025040101 {

    /**
     * 1ms	击败100.00%
     * 41.83MB	击败30.61%
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
        int ans = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);

        if (ax2 <= bx1 || ax1 >= bx2 || ay2 <= by1 || ay1 >= by2) {
            return ans;
        }
        // 寻找重合的部分
        ans -= (Math.min(ax2, bx2) - Math.max(ax1, bx1)) * (Math.min(ay2, by2) - Math.max(ay1, by1));
        return ans;
    }
}
