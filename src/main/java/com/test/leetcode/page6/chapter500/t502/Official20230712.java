package com.test.leetcode.page6.chapter500.t502;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: Official20230712
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/12 16:37
 * @Version: 1.0
 */
public class Official20230712 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            // 需要资本
            arr[i][0] = capital[i];
            // 收益
            arr[i][1] = profits[i];
        }
        // 根据需要的资本排序
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; ++i) {
            while (curr < n && arr[curr][0] <= w) {
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;
    }

}
