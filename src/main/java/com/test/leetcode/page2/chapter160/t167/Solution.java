package com.test.leetcode.page2.chapter160.t167;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-06 16:10
 */
public class Solution {

    /**
     * 呃，我曾经写出过这么牛逼的代码？我现在都没想到
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer index = map.get(target - numbers[i]);
            if (index != null) {
                return new int[]{index + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }
}
