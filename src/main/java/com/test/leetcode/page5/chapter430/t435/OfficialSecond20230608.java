package com.test.leetcode.page5.chapter430.t435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: OfficialSecond20230608
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/8 10:22
 * @Version: 1.0
 */
public class OfficialSecond20230608 {

    /**
     * 方法二：贪心
     * <p>
     * 执行用时：48 ms, 在所有 Java 提交中击败了86.19%的用户
     * 内存消耗：94.1 MB, 在所有 Java 提交中击败了93.28%的用户
     * 通过测试用例：58 / 58
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
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        // 尾部值
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

}
