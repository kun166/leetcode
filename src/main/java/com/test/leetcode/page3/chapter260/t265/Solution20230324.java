package com.test.leetcode.page3.chapter260.t265;

/**
 * @ClassName: Solution20230324
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/24 16:05
 * @Version: 1.0
 */
public class Solution20230324 {

    public int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        int[] array1 = new int[k];
        int[] array2 = new int[k];
        for (int i = 0; i < n; i++) {
            // 循环每一栋房子
            for (int j = 0; j < k; j++) {
                // 循环每一种颜色
                int min = Integer.MAX_VALUE;
                for (int m = 0; m < k; m++) {
                    // 循环除当前颜色外，求其它颜色的最小值
                    if (m == j) {
                        continue;
                    }
                    min = Math.min(min, array1[m]);
                }
                array2[j] = min + costs[i][j];
            }
            // 互换两个数组
            int[] array = array1;
            array1 = array2;
            array2 = array;
        }

        int min = Integer.MAX_VALUE;
        for (int m = 0; m < k; m++) {
            // 循环除当前颜色外，求其它颜色的最小值
            min = Math.min(min, array1[m]);
        }
        return min;
    }

}
