package com.test.leetcode.page3.chapter250.t253;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: OfficialSecond20230315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/15 21:38
 * @Version: 1.0
 */
public class OfficialSecond20230315 {

    /**
     * 方法二：有序化
     * 这个方法感觉很牛
     * 执行用时：7 ms, 在所有 Java 提交中击败了42.63%的用户
     * 内存消耗：41.3 MB, 在所有 Java 提交中击败了69.03%的用户
     * 通过测试用例：78 / 78
     * <p>
     * 这又是颠覆三观的时候，居然用时更多了……
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        // Sort the intervals by end time
        Arrays.sort(
                end,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });

        // Sort the intervals by start time
        Arrays.sort(
                start,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });

        // The two pointers in the algorithm: e_ptr and s_ptr.
        int startPointer = 0, endPointer = 0;

        // Variables to keep track of maximum number of rooms used.
        int usedRooms = 0;

        // Iterate over intervals.
        while (startPointer < intervals.length) {

            // 这个地方和方法一原理是一样的，保证最大房间数
            // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
            if (start[startPointer] >= end[endPointer]) {
                usedRooms -= 1;
                endPointer += 1;
            }

            // We do this irrespective of whether a room frees up or not.
            // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
            // remain the same in that case. If no room was free, then this would increase used_rooms
            usedRooms += 1;
            startPointer += 1;

        }

        return usedRooms;
    }


}
