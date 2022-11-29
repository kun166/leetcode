package com.test.leetcode.page1.chapter70.t74;

import org.junit.Test;

/**
 * @ClassName: Solution20221128
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/28 19:57
 * @Version: 1.0
 */
public class Solution20221128 {

    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix, 30));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) {
            return false;
        }
        // 感觉还是得二分法吧？
        // 先确定在哪行
        int start = 0, end = m - 1;
        if (start < end) {
            while (start < end) {
                if (matrix[start][0] == target || matrix[end][0] == target) {
                    return true;
                }
                // mid 可能等于start
                int mid = start + (end - start) / 2;
                if (matrix[mid][0] == target) {
                    return true;
                }
                if (matrix[mid][0] > target) {
                    end = mid - 1;
                } else {
                    if (start == mid) {
                        if (matrix[end][0] <= target) {
                            start = end;
                            break;
                        }
                        break;
                    }
                    start = mid;
                }
            }
        }
        // 确定在第start行，继续二分
        int left = 0, right = n - 1;
        if (left == right) {
            return matrix[start][left] == target;
        }
        while (left < right) {
            if (matrix[start][left] == target || matrix[start][right] == target) {
                return true;
            }
            int mid = left + (right - left) / 2;
            if (matrix[start][mid] == target) {
                return true;
            }
            if (matrix[start][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
