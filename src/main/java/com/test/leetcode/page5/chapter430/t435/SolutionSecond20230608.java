package com.test.leetcode.page5.chapter430.t435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: OfficialSecond20230606
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/8 10:09
 * @Version: 1.0
 */
public class SolutionSecond20230608 {

    /**
     * 贪心算法
     * <p>
     * 执行用时：63 ms, 在所有 Java 提交中击败了21.84%的用户
     * 内存消耗：94.2 MB, 在所有 Java 提交中击败了91.18%的用户
     * 通过测试用例：58 / 58
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int ans = 0, n = intervals.length, index = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[index][1]) {
                //ans不变
                index = i;
            } else {
                ans++;
                // 删除尾数大的那个
                if (intervals[i][1] <= intervals[index][1]) {
                    index = i;
                }
            }
        }
        return ans;
    }
}
