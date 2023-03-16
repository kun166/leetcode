package com.test.leetcode.page3.chapter250.t253;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: SolutionFirst20230315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/15 21:00
 * @Version: 1.0
 */
public class SolutionFirst20230315 {

    @Test
    public void test() {
        System.out.println(minMeetingRooms(new int[][]{{9, 10}, {4, 9}, {4, 17}}));
    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了42.63%的用户
     * 内存消耗：41.4 MB, 在所有 Java 提交中击败了62.86%的用户
     * 通过测试用例：78 / 78
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        int ans = 0;
        // 先排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Queue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < intervals.length; i++) {
            while (!queue.isEmpty() && queue.peek() <= intervals[i][0]) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
            ans = Math.max(ans, queue.size());
        }
        return ans;
    }
}
