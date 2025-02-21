package com.test.leetcode.page5.chapter430.t435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: OfficialFirst20230608
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/8 10:20
 * @Version: 1.0
 */
public class OfficialFirst20230608 {

    /**
     * 方法一：动态规划
     * 呃，官方的这个解法超出时间限制，是认真的么
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }

}
