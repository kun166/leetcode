package com.test.leetcode.page1.chapter10.t11;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-14 12:55
 */
public class Solution {

    @Test
    public void test() {
        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(max(array));
    }

    public int max(int[] array) {
        int length = array.length;
        int max = 0;

        for (int i = 0; i < length; i++) {
            int currentH = 0;
            for (int j = length - 1; j > i; j--) {
                if (array[j] > currentH) {
                    currentH = array[j];
                    int minH = array[i] > array[j] ? array[j] : array[i];
                    int area = minH * (j - i);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }
}
