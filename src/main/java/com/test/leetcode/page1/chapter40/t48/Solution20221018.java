package com.test.leetcode.page1.chapter40.t48;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20221018
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/18 16:50
 * @Version: 1.0
 */
public class Solution20221018 {

    @Test
    public void test() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        System.out.println(JSON.toJSONString(matrix));
        rotate(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }


    public void rotate(int[][] matrix) {
        // 先横竖换位置
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int mid = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = mid;
            }
        }
        // 竖排对调
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int mid = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = mid;
            }
        }
    }
}
