package com.test.leetcode.page3.chapter220.t221;

import org.junit.Test;

/**
 * @ClassName: Solution20230228
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/28 09:18
 * @Version: 1.0
 */
public class Solution20230228 {

    @Test
    public void test() {
        System.out.println(maximalSquare(new char[][]{
                {'1', '0', '1', '0'},
                {'1', '0', '1', '1'},
                {'1', '0', '1', '1'},
                {'1', '1', '1', '1'}
        }));
//        System.out.println(maximal(new int[]{4, 1, 4, 3}));
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 每一行的1的个数
        int[] array = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    array[j] = 0;
                } else {
                    array[j]++;
                }
            }
            max = Math.max(max, maximal(array));
        }
        return max * max;
    }

    /**
     * 给你一个数组，求这个数组包含的最大的正方形的边长
     *
     * @param array
     * @return
     */
    public int maximal(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            // 遍历每一个点，计算左边界，计算右边界
            // 计算左边界
            int left = i;
            while (left > 0 && array[left - 1] >= array[i]) {
                left--;
            }
            // 计算右边界
            int right = i;
            while (right < array.length - 1 && array[right + 1] >= array[i]) {
                right++;
            }
            // 计算边长
            max = Math.max(max, Math.min(right - left + 1, array[i]));
        }
        return max;
    }
}
