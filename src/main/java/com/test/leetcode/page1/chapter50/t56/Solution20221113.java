package com.test.leetcode.page1.chapter50.t56;

import java.util.Arrays;

/**
 * @ClassName: Solution20221113
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/13 16:29
 * @Version: 1.0
 */
public class Solution20221113 {

    public int[][] merge(int[][] intervals) {
        // 感觉得排序啊
        Arrays.sort(intervals, (a1, a2) -> {
            if (a1[0] > a2[0]) {
                return 1;
            } else if (a1[0] == a2[0]) {
                return 0;
            } else {
                return -1;
            }
        });
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[index][1]) {
                // 能合并
                intervals[index][1] = Math.max(intervals[i][1], intervals[index][1]);
            } else {
                // 不能合并
                index++;
                intervals[index][0] = intervals[i][0];
                intervals[index][1] = intervals[i][1];
            }
        }
        int[][] ans = new int[index + 1][];
        System.arraycopy(intervals, 0, ans, 0, index + 1);
        return ans;
    }
}
