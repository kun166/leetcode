package com.test.leetcode.page3.chapter250.t252;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: OfficialSecond20230315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/15 20:51
 * @Version: 1.0
 */
public class OfficialSecond20230315 {

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了94.15%的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了92.82%的用户通过
     * 测试用例：78 / 78
     *
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0])
                return false;
        }
        return true;
    }
}
