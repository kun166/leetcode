package com.test.leetcode.page1.chapter50.t57;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Official20221113
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/13 18:34
 * @Version: 1.0
 */
public class Official20221113 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 新数组的左侧值
        int left = newInterval[0];
        // 新数组的右侧值
        int right = newInterval[1];
        // 是否已放置？
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
