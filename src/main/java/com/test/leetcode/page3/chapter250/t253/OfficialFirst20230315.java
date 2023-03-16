package com.test.leetcode.page3.chapter250.t253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: OfficialFirst20230315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/15 21:33
 * @Version: 1.0
 */
public class OfficialFirst20230315 {

    /**
     * 方法一：优先队列
     * 确实稍微快1秒
     * 执行用时：6 ms, 在所有 Java 提交中击败了74.97%的用户
     * 内存消耗：41.4 MB, 在所有 Java 提交中击败了58.74%的用户
     * 通过测试用例：78 / 78
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        // Sort the intervals by start time
        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    public int compare(final int[] a, final int[] b) {
                        return a[0] - b[0];
                    }
                });

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // 这个地方很巧妙，如果有空闲的会议室，只需要减去一个就行，保证下面加一个会议室的时候，不少于最大会议室
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
}
