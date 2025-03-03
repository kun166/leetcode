package com.test.leetcode.page1.chapter50.t54;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20250226
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/26 09:17
 * @Version: 1.0
 */
public class Solution2025022601 {

    /**
     * 感觉碰到矩阵的问题，还是四边法比较好用？
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // 定义四个边的范围
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while (true) {
            // 退出条件
            if (top > bottom || left > right) {
                return list;
            }
            // 1,从上左到上右,
            for (int i = 0; i <= right - left; i++) {
                list.add(matrix[top][left + i]);
            }
            top++;
            // 2,从右上到右下
            for (int i = 0; i <= bottom - top; i++) {
                list.add(matrix[top + i][right]);
            }
            right--;
            // 3,从右下到左下
            if (top <= bottom) {
                for (int i = right - left; i >= 0; i--) {
                    list.add(matrix[bottom][left + i]);
                }
                bottom--;
            }
            // 4,从左下到左上
            if (left <= right) {
                for (int i = bottom - top; i >= 0; i--) {
                    list.add(matrix[top + i][left]);
                }
                left++;
            }
        }
    }
}
