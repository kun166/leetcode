package com.test.leetcode.page3.chapter250.t252;

/**
 * @ClassName: Solution20230315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/15 20:28
 * @Version: 1.0
 */
public class SolutionFirst20230315 {

    /**
     * 最简单的方式，冒泡法
     * 执行用时：215 ms, 在所有 Java 提交中击败了5.05%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了48.14%的用户
     * 通过测试用例：78 / 78
     *
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (!(intervals[i][0] >= intervals[j][1] || intervals[i][1] <= intervals[j][0])) {
                    return false;
                }
            }
        }
        return true;
    }
}
