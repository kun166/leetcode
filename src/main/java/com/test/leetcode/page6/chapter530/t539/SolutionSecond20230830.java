package com.test.leetcode.page6.chapter530.t539;

import java.util.List;

/**
 * @ClassName: Solution20230830
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/30 09:47
 * @Version: 1.0
 */
public class SolutionSecond20230830 {


    /**
     * 1ms击败 100.00%使用 Java 的用户
     * 41.85MB击败 53.99%使用 Java 的用户
     *
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        int size = 24 * 60;
        if (timePoints.size() > size) {
            return 0;
        }
        boolean[] array = new boolean[size];
        // 先解析所有的timePoints
        for (String s : timePoints) {
            int num = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
            if (array[num]) {
                return 0;
            }
            array[num] = true;
        }
        int ans = size;
        Integer start = null, end = null;
        for (int i = 0; i < size; i++) {
            if (!array[i]) {
                continue;
            }
            if (start == null) {
                start = i;
            } else {
                ans = Math.min(ans, i - end);
            }
            end = i;
        }
        ans = Math.min(ans, start + size - end);
        return ans;
    }
}
