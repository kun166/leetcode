package com.test.leetcode.page4.chapter370.t378;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: OfficialSecond20230516
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/16 08:33
 * @Version: 1.0
 */
public class OfficialSecond20230516 {

    /**
     * 方法二：归并排序
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // 长度为3的数组，第二个位置标识行，第三个位置标识列，第一个位置标识行和列对应的矩阵中的值
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }
}
