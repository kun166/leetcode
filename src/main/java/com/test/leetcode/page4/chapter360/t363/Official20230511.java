package com.test.leetcode.page4.chapter360.t363;

import java.util.TreeSet;

/**
 * @ClassName: Official20230511
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/11 07:42
 * @Version: 1.0
 */
public class Official20230511 {

    /**
     * 方法一：有序集合
     * <p>
     * 这个算的思路是：确定矩阵的上边界，确定矩阵的下边界
     * 上边界和下边界确定之后，每一列的累加和就是一维数组了
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        // 定义矩阵行数，列数
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            // 枚举上边界。上边界从0到m-1
            // 定义每一列的前缀和
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) {
                // 枚举下边界
                // 下边界从i到m-1
                for (int c = 0; c < n; ++c) {
                    // 累加每一列的和
                    sum[c] += matrix[j][c];
                }
                // 下面这个算法就是从一维数组中寻找不超过 K 的最大数值和
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    // floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
                    // ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }

}
