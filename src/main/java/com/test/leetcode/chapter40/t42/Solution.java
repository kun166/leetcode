package com.test.leetcode.chapter40.t42;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-28 16:53
 */
public class Solution {

    @Test
    public void test() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public int trap(int[] height) {
        int length = height.length;
        int water = 0;
        for (int i = 0; i < length - 1; i++) {
            //for循环，寻找下一个比它高的柱子
            int index = -1;
            for (int j = i + 1; j < length; j++) {
                if (height[j] >= height[i]) {
                    index = j;
                    break;
                }
            }

            // 如果没有比它更高或者平高的柱子，则找剩余的最高的那个柱子
            if (index == -1) {
                index = i + 1;
                for (int j = i + 2; j < length; j++) {
                    if (height[j] >= height[index]) index = j;
                }
            }
            // 计算i到index的容积
            if (index != -1) {
                water += coputer(height, i, index);
            }
            i = index - 1;
        }
        return water;
    }

    /**
     * 计算容积
     *
     * @param height
     * @param start
     * @param end
     * @return
     */
    public int coputer(int[] height, int start, int end) {
        if (height[start] == 0 || height[end] == 0) return 0;
        int min = height[start] > height[end] ? height[end] : height[start];
        int size = min * (end - start - 1);
        for (int i = start + 1; i < end; i++) {
            size -= height[i];
        }
        return size;
    }
}
