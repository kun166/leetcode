package com.test.leetcode.page4.chapter370.t378;

import java.util.Arrays;

/**
 * @ClassName: OfficialFirst20230516
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/16 08:32
 * @Version: 1.0
 */
public class OfficialFirst20230516 {

    /**
     * 方法一：直接排序
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }
}
