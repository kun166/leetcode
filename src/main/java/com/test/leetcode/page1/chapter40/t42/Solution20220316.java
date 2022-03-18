package com.test.leetcode.page1.chapter40.t42;

/**
 * @ClassName: Solution20220316
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/16 15:58
 * @Version: 1.0
 */
public class Solution20220316 {

    public int trap(int[] height) {
        int length = height.length;
        int ant = 0;
        int start = 0, end = -1;
        while (start < length - 1) {
            for (int i = start + 1; i < length; i++) {
                // 寻找高度比start位置上高或者次高的位置
                if (height[i] >= height[start]) {
                    end = i;
                    break;
                }
                if (end == -1 || height[i] > height[end]) {
                    end = i;
                }
            }
            // 计算本次储水
            ant += trap(height, start, end);
            // 计算下一个储水
            start = end;
            end = -1;
        }
        return ant;
    }

    /**
     * 计算从start到end的水量
     *
     * @param height
     * @param start
     * @param end
     * @return
     */
    public int trap(int[] height, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int ant = Math.min(height[start], height[end]) * (end - start - 1);
        for (int i = start + 1; i < end; i++) {
            ant -= height[i];
        }
        return ant;
    }
}
