package com.test.leetcode.page1.chapter50.t54;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Official2022111302
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/13 11:59
 * @Version: 1.0
 */
public class Official2022111302 {

    /**
     * 按层模拟
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        // 定义四个方向的边界
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                // 这个是模拟的 从左向右
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                // 这个模拟的是从上向下
                order.add(matrix[row][right]);
            }
            // 下面这判断就是细节问题了，如果不加的话，从右向左可能重复了从左向右的访问了
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
