package com.test.leetcode.page1.chapter80.t85;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName: Solution2025030602
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/6 11:04
 * @Version: 1.0
 */
public class Solution2025030602 {

    @Test
    public void test() {
        System.out.println(maximalRectangle(
                new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}}));
    }

    /**
     * 这题不就是上个题的延续么？
     * 虽然不做上一个题，不知道这题还有这解法……
     * 试试吧
     *
     * 6ms 击败77.79%
     * 48.63MB 击败5.11%
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] intMatrix = new int[m][n];
        for (int i = 0; i < n; i++) {
            // 初始化第一行
            if (matrix[0][i] == '1')
                intMatrix[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    intMatrix[i][j] = 1 + intMatrix[i - 1][j];
                }
            }
        }
        int area = 0;
        for (int i = 0; i < m; i++) {
            area = Math.max(area, largestRectangleArea(intMatrix[i]));
        }
        return area;
    }

    /**
     * 上个题的解法啊……
     * <p>
     * 呃，这下面的代码,居然又错了好几次……
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, area = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!ll.isEmpty() && heights[ll.peek()] >= heights[i])
                right[ll.pop()] = i;
            left[i] = ll.isEmpty() ? -1 : ll.peek();
            ll.push(i);
        }
        for (int i = 0; i < n; i++) {
            area = Math.max(area, heights[i] * (right[i] - left[i] - 1));
        }
        return area;
    }
}
