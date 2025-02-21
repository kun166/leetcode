package com.test.leetcode.page5.chapter450.t452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Solution20230615
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/15 08:47
 * @Version: 1.0
 */
public class Solution20230615 {

    /**
     * 执行用时：59 ms, 在所有 Java 提交中击败了35.61%的用户
     * 内存消耗：74.4 MB, 在所有 Java 提交中击败了92.51%的用户
     * 通过测试用例：50 / 50
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        // 先排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] > o2[1] ? 1 : -1;
                }
                return o1[0] > o2[0] ? 1 : -1;
            }
        });
        int left = 0, right = 1;
        for (; right < points.length; right++) {
            // right和left比较
            // 1,如果有交集，取交集
            // 2,如果没有交集，则left++
            if (points[left][1] >= points[right][0]) {
                // 有交集，取交集
                points[left][0] = points[right][0];
                points[left][1] = Math.min(points[left][1], points[right][1]);
            } else {
                // 无交集
                left++;
                points[left][0] = points[right][0];
                points[left][1] = points[right][1];
            }
        }
        return left + 1;
    }
}
