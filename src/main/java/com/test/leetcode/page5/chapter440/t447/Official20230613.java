package com.test.leetcode.page5.chapter440.t447;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Official20230613
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/13 09:12
 * @Version: 1.0
 */
public class Official20230613 {

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] q : points) {
                int distance = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ans += entry.getValue() * (entry.getValue() - 1);
            }
        }
        return ans;
    }
}
