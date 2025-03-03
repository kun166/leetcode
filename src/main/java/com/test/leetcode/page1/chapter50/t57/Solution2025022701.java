package com.test.leetcode.page1.chapter50.t57;

/**
 * @ClassName: Solution2025022701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/27 08:53
 * @Version: 1.0
 */
public class Solution2025022701 {

    /**
     * 我有点无语了，错了N次
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 双指针吧
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        // 1,先找到插入的位置
        int index = 0;
        while (index < intervals.length) {
            // 一共有多少种情况?
            // 第一种,插入当前位置
            // 第二种,合并当前位置
            // 第三种,插入最后位置
            if (newInterval[1] < intervals[index][0]) {
                // 新数组两边都不接触，将新数组插入当前index位置即可
                int[][] ans = new int[intervals.length + 1][];
                for (int i = 0; i < index; i++) {
                    // index之前的
                    ans[i] = intervals[i];
                }
                // index位置的
                ans[index] = newInterval;
                for (int i = index; i < intervals.length; i++) {
                    // index之后位置的
                    ans[i + 1] = intervals[i];
                }
                return ans;
            } else if (newInterval[0] <= intervals[index][1]) {
                // 合并
                break;
            }
            index++;
        }
        if (index == intervals.length) {
            // 插入到最后
            int[][] ans = new int[intervals.length + 1][];
            for (int i = 0; i < intervals.length; i++) {
                ans[i] = intervals[i];
            }
            ans[index] = newInterval;
            return ans;
        }

        // 合并,双指针
        intervals[index][0] = Math.min(intervals[index][0], newInterval[0]);
        intervals[index][1] = Math.max(intervals[index][1], newInterval[1]);
        int right = index + 1;
        while (right < intervals.length) {
            if (intervals[right][0] > intervals[index][1]) {
                // 返回
                int[][] ans = new int[index + 1 + intervals.length - right][];
                for (int i = 0; i <= index; i++) {
                    ans[i] = intervals[i];
                }
                for (int i = 0; i < intervals.length - right; i++) {
                    ans[index + 1 + i] = intervals[right + i];
                }
                return ans;
            } else {
                // 合并
                intervals[index][1] = Math.max(intervals[index][1], intervals[right][1]);
            }
            right++;
        }
        int[][] ans = new int[index + 1][];
        for (int i = 0; i <= index; i++) {
            ans[i] = intervals[i];
        }
        return ans;
    }
}
