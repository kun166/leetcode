package com.test.leetcode.chapter10.t11;

import org.junit.Test;

/**
 * 找最大面积。
 *
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-19 15:47
 */
public class Solution20201019 {

    @Test
    public void test() {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] array) {
        int maxArea = 0;
        int start = 0, end = array.length - 1;
        while (start < end) {
            int area;
            if (array[start] < array[end]) {
                area = array[start] * (end - start);
                start++;
            } else {
                area = array[end] * (end - start);
                end--;
            }
            if (area > maxArea) maxArea = area;
        }
        return maxArea;
    }

}
