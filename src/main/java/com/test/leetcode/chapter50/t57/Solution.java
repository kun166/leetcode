package com.test.leetcode.chapter50.t57;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-06 10:43
 */
public class Solution {

    @Test
    public void test() {
        int[][] intervals = new int[5][2];
        intervals[0] = new int[]{1, 2};
        intervals[1] = new int[]{3, 5};
        intervals[2] = new int[]{6, 7};
        intervals[3] = new int[]{8, 10};
        intervals[4] = new int[]{12, 16};
        intervals = insert(intervals, new int[]{4, 8});
        for (int i = 0; i < intervals.length; i++) {
            System.out.println();
            System.out.print(intervals[i][0] + "," + intervals[i][1]);
        }
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        int start = -1, end = -1;
        // 0:初始化,1,已插入,2,已合并
        int type = 0;
        for (int i = 0; i < length; i++) {
            if (type == 0) {
                if (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[0]) {
                    //能合并
                    // 修改状态为已合并
                    type = 2;
                    // 修改起始的位置为i
                    start = i;
                    end = i;
                    // 合并
                    intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
                    intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
                } else if (newInterval[1] < intervals[i][0]) {
                    // 能插入
                    // 修改状态为已插入
                    type = 1;
                    // 修改插入位置为i
                    start = i;
                    break;
                }
            } else if (type == 2) {
                if (intervals[start][1] >= intervals[i][0]) {
                    // 继续合并
                    intervals[start][1] = Math.max(intervals[i][1], intervals[start][1]);
                    end = i;
                } else {
                    // 不能合并就退出
                    break;
                }
            }
        }
        int[][] ans;
        if (type == 0) {
            // 说明要插到最后
            ans = Arrays.copyOf(intervals, length + 1);
            ans[length] = newInterval;
        } else if (type == 1) {
            ans = new int[length + 1][2];
            arraycopy(ans, 0, intervals, 0, start);
            ans[start] = newInterval;
            arraycopy(ans, start + 1, intervals, start, length - start);
        } else {
            ans = new int[length - end + start][2];
            arraycopy(ans, 0, intervals, 0, start + 1);
            arraycopy(ans, start + 1, intervals, end + 1, length - 1 - end);
        }
        return ans;
    }

    public void arraycopy(int[][] src, int srcPos,
                          int[][] dest, int destPos,
                          int length) {
        for (int i = 0; i < length; i++) {
            src[srcPos + i] = dest[destPos + i];
        }
    }
}
