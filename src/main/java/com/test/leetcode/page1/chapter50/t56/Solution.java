package com.test.leetcode.page1.chapter50.t56;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-06 09:40
 */
public class Solution {

    @Test
    public void test() {
        int[][] intervals = new int[4][2];
        intervals[0] = new int[]{1, 3};
        intervals[1] = new int[]{2, 6};
        intervals[2] = new int[]{8, 10};
        intervals[3] = new int[]{15, 18};

        intervals = merge(intervals);
        for (int i = 0; i < intervals.length; i++) {
            System.out.println();
            System.out.print(intervals[i][0] + "," + intervals[i][1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length == 0)
            return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));

        int l = 0;
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] <= intervals[l][1]) {
                // 能合并。
                intervals[l][1] = Math.max(intervals[l][1], intervals[i][1]);
            } else {
                l++;
                intervals[l][0] = intervals[i][0];
                intervals[l][1] = intervals[i][1];
            }
        }
        int[][] ans = new int[l + 1][2];
        for (int i = 0; i <= l; i++) {
            ans[i][0] = intervals[i][0];
            ans[i][1] = intervals[i][1];
        }
        return ans;
    }
}
