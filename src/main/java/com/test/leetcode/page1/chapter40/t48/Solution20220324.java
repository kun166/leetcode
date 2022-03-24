package com.test.leetcode.page1.chapter40.t48;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20220324
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/24 09:30
 * @Version: 1.0
 */
public class Solution20220324 {

    @Test
    public void test() {
        int[][] matrix = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        System.out.println(JSON.toJSONString(matrix));
        rotate(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return;
        }
        // 沿上下对角线互相交换位置
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int middle = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = middle;
            }
        }
        // 左右互换位置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int middle = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = middle;
            }
        }
    }
}
