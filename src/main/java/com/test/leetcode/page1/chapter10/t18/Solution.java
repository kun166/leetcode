package com.test.leetcode.page1.chapter10.t18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-16 16:38
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<int[]> list = find(nums, 0);
        for (int[] a : list) {
            System.out.println();
            for (int i : a) {
                System.out.print(i + ",");
            }
        }
    }


    public List<int[]> find(int[] array, int target) {
        List<int[]> list = new ArrayList<>();
        if (array.length < 4) {
            return list;
        }

        // 先排序
        Arrays.sort(array);
        int length = array.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && array[i] == array[i - 1]) continue;
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && array[j] == array[j - 1]) continue;
                int findN = target - array[i] - array[j];
                int four = length - 1;
                for (int h = j + 1; h < length - 1; h++) {
                    if (h > j + 1 && array[h] == array[h - 1]) continue;
                    while (h < four && findN - array[h] < array[four]) four--;
                    if (h == four) break;
                    if (findN - array[h] == array[four]) {
                        int[] a = {array[i], array[j], array[h], array[four]};
                        list.add(a);
                    }
                }
            }
        }
        return list;
    }
}
