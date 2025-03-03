package com.test.leetcode.page1.chapter50.t56;

import java.util.Arrays;

/**
 * @ClassName: Solution2025022601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/26 14:39
 * @Version: 1.0
 */
public class Solution2025022601 {

    public int[][] merge(int[][] intervals) {
        // 先排序?双指针?
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int left = 0, right = 1;
        while (right < intervals.length) {
            if (intervals[right][0] <= intervals[left][1]) {
                // 需要合并
                intervals[left][1] = Math.max(intervals[left][1], intervals[right][1]);
            } else {
                left++;
                intervals[left][0] = intervals[right][0];
                intervals[left][1] = intervals[right][1];
            }
            right++;
        }
        int[][] ans = new int[left + 1][];
        for (int i = 0; i <= left; i++) {
            ans[i] = intervals[i];
        }
        return ans;
    }
}
