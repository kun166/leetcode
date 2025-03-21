package com.test.leetcode.page2.chapter140.t149;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20230206
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/6 21:24
 * @Version: 1.0
 */
public class Solution20230206 {

    /**
     * 呃，好吧，我还以为这是某个大神的解法呢……
     * 原来是我自己的写的解,且是完全错误的……
     *
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point : points) {
            int key = point[0] - point[1];
            Integer value = map.get(key);
            if (value == null) {
                value = 0;
            }
            value++;
            map.put(key, value);
            max = Math.max(max, value);
        }
        map.clear();
        for (int[] point : points) {
            int key = point[0] + point[1];
            Integer value = map.get(key);
            if (value == null) {
                value = 0;
            }
            value++;
            map.put(key, value);
            max = Math.max(max, value);
        }
        return max;
    }
}
