package com.test.leetcode.chapter50.t54;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-05 15:52
 */
public class Solution {

    @Test
    public void test() {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};

        List<Integer> list = spiralOrder(matrix);
        for (int i : list) {
            System.out.print(i + ",");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        if (m == 0)
            return ans;
        int n = matrix[0].length;
        int i1 = 0, i2 = 0, c = 0, d = 1;
        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[i2][i1]);
            if (d == 1) {
                // 预测下一个走向和下一个点
                if (i1 == n - 1 - c) {
                    d = 2;
                    i2++;
                } else {
                    i1++;
                }
            } else if (d == 2) {
                // 预测下一个走向和下一个点
                if (i2 == m - 1 - c) {
                    d = 3;
                    i1--;
                } else {
                    i2++;
                }
            } else if (d == 3) {
                // 预测下一个走向和下一个点
                if (i1 == c) {
                    d = 4;
                    i2--;
                } else {
                    i1--;
                }
            } else if (d == 4) {
                // 预测下一个走向和下一个点
                if (i2 == c + 1) {
                    c++;
                    d = 1;
                    i1++;
                } else {
                    i2--;
                }
            }
        }
        return ans;
    }
}
