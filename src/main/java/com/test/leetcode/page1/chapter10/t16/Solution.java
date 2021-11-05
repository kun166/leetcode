package com.test.leetcode.page1.chapter10.t16;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-14 17:07
 */
public class Solution {

    @Test
    public void test() {
        int[] array = {-1, 2, 1, 4, 3, -4};
        System.out.println(find(array, 12));

    }

    public int find(int[] array, int target) {
        int length = array.length;
        // 感觉还是得需要排序的
        Arrays.sort(array);
        int difValue = array[0] + array[1] + array[length - 1] - target;
        for (int first = 0; first < length - 2; first++) {
            int second = first + 1, third = length - 1;
            int preSum = array[first] + array[second] + array[third] - target;
            while (second < third) {
                int sum = array[first] + array[second] + array[third] - target;
                if (Math.abs(difValue) > Math.abs(sum)) {
                    difValue = sum;
                }
                if (Math.abs(preSum) < Math.abs(sum)) {
                    break;
                }
                if (sum > 0) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return difValue + target;
    }
}
