package com.test.leetcode.chapter120.t120;

import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-06-10 10:57
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] array = new int[length];
        array[0] = triangle.get(0).get(0);
        for (int i = 1; i < length; i++) {
            array[i] = 0;
        }
        for (int i = 1; i < length; i++) {
            int value = array[0];
            for (int j = 0; j <= i; j++) {
                int cValue = array[j];
                if (j == 0) {
                    array[0] += triangle.get(i).get(0);
                } else if (j == i) {
                    array[j] += value + triangle.get(i).get(j);
                } else {
                    array[j] = triangle.get(i).get(j) + Math.min(value, cValue);
                }
                value = cValue;
            }
        }
        int result = array[0];
        for (int i = 1; i < length; i++) {
            result = Math.min(result, array[i]);
        }
        return result;
    }
}
