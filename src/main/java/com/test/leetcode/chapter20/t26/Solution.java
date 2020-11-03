package com.test.leetcode.chapter20.t26;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-17 16:00
 */
public class Solution {

    @Test
    public void test() {
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(array));
        for (int i : array) {
            System.out.println(i);
        }
    }

    public int removeDuplicates(int[] array) {
        int length = array.length;
        for (int i = length - 2; i >= 0; i--) {
            if (array[i] == array[i + 1]) {
                length--;
                // 移动数组
                moveLeft(array, i, length);
            }
        }
        return length;
    }

    public void moveLeft(int[] array, int index, int length) {
        for (int i = index; i < length; i++) {
            array[i] = array[i + 1];
        }
        array[length] = 0;
    }
}
