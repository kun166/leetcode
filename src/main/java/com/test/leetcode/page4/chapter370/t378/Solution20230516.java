package com.test.leetcode.page4.chapter370.t378;

/**
 * @ClassName: Solution20230516
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/16 07:50
 * @Version: 1.0
 */
public class Solution20230516 {

    /**
     * 执行用时：29 ms, 在所有 Java 提交中击败了5.70%的用户
     * 内存消耗：46.3 MB, 在所有 Java 提交中击败了81.04%的用户
     * 通过测试用例：86 / 86
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (k == 1) {
            return matrix[0][0];
        }
        int n = matrix.length;
        int[] index = new int[n];
        while (k > 0) {
            int num = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (index[i] < n) {
                    num = Math.min(num, matrix[i][index[i]]);
                }
            }
            for (int i = 0; i < n; i++) {
                if (index[i] >= n) {
                    continue;
                }
                if (matrix[i][index[i]] == num) {
                    k--;
                    if (k == 0) {
                        return num;
                    }
                    index[i]++;
                }
            }
        }
        return -1;
    }


}
