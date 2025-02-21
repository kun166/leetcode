package com.test.leetcode.page5.chapter450.t452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Official20230615
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/15 09:13
 * @Version: 1.0
 */
public class Official20230615 {

    /**
     * 方法一：排序 + 贪心
     * 这个官方解答秒啊
     * 执行用时：51 ms, 在所有 Java 提交中击败了99.76%的用户
     * 内存消耗：74.8 MB, 在所有 Java 提交中击败了75.23%的用户
     * 通过测试用例：50 / 50
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 根据右边界排序。第一箭就在最小右边界的那个地方射出。能保证射到最多的气球，而无需考虑左边界……
        // 这种思路的秒点在于只需要在右边界射出就行了，没必要找出左边界。
        // 例如三个气球{1,10},{3,6},{2,8},左右边界为{3,6},只要在3,4,5,6射都是可以的。
        // 但是贪心算法，在6的地方射出，和在3,4,5射出一样，没必要找到左边界3
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

}
