package com.test.leetcode.page3.chapter250.t252;

/**
 * @ClassName: OfficialFirst20230315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/15 20:48
 * @Version: 1.0
 */
public class OfficialFirst20230315 {

    /**
     * 执行用时：117 ms, 在所有 Java 提交中击败了6.91%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了38.03%的用户通过
     * 测试用例：78 / 78
     *
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (overlap(intervals[i], intervals[j]))
                    return false;
            }
        }
        return true;
    }

    public static boolean overlap(int[] i1, int[] i2) {
        // 可以改成  (Math.min(i1[1], i2[1]) > Math.max(i1[0], i2[0]));
        return ((i1[0] >= i2[0] && i1[0] < i2[1]) || (i2[0] >= i1[0] && i2[0] < i1[1]));
    }

}
