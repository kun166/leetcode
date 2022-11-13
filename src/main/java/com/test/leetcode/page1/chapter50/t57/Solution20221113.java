package com.test.leetcode.page1.chapter50.t57;

/**
 * @ClassName: Solution20221113
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/13 17:38
 * @Version: 1.0
 */
public class Solution20221113 {
    /**
     * 这题感觉比上一个题简单
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        if (length == 0) {
            return new int[][]{newInterval};
        }
        // 排序好的，newInterval和原数组第一个
        if (intervals[0][0] > newInterval[1]) {
            // 不能合并，直接返回了
            int[][] ans = new int[length + 1][];
            ans[0] = newInterval;
            System.arraycopy(intervals, 0, ans, 1, length);
            return ans;
        }

        // 排序好的，newInterval和原数组第一个
        if (intervals[length - 1][1] < newInterval[0]) {
            // 不能合并，直接返回了
            int[][] ans = new int[length + 1][];
            ans[length] = newInterval;
            System.arraycopy(intervals, 0, ans, 0, length);
            return ans;
        }

        int index = 0;
        boolean hasMerg = false;
        for (int i = 0; i < length; i++) {
            if (!hasMerg) {
                if (intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]
                        || intervals[i][0] >= newInterval[0] && intervals[i][0] <= newInterval[1]) {
                    // 能合并
                    index = i;
                    hasMerg = true;
                    // 合并
                    intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
                    intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
                }
                if (i > 0 && intervals[i][0] > newInterval[1] && intervals[i - 1][1] < newInterval[0]) {
                    int[][] ans = new int[length + 1][];
                    System.arraycopy(intervals, 0, ans, 0, i);
                    ans[i] = newInterval;
                    System.arraycopy(intervals, i, ans, i + 1, length - i);
                    return ans;
                }
            }
            if (hasMerg && i != index) {
                // 看看两者是不是能合并
                if (intervals[index][1] >= intervals[i][0]) {
                    // 能合并
                    intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
                } else {
                    // 不能合并。就可以返回了
                    int[][] ans = new int[index + 1 + length - i][];
                    System.arraycopy(intervals, 0, ans, 0, index + 1);
                    System.arraycopy(intervals, i, ans, index + 1, length - i);
                    return ans;
                }
            }
        }
        int[][] ans = new int[index + 1][];
        System.arraycopy(intervals, 0, ans, 0, index + 1);
        return ans;
    }
}
