package com.test.leetcode.page5.chapter430.t436;

import java.util.Arrays;

/**
 * @ClassName: Solution20230608
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/8 11:17
 * @Version: 1.0
 */
public class Solution20230608 {

    /**
     * 执行用时：741 ms, 在所有 Java 提交中击败了5.04%的用户
     * 内存消耗：49 MB, 在所有 Java 提交中击败了5.19%的用户
     * 通过测试用例：19 / 19
     *
     * @param intervals
     * @return
     */
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (intervals[i][1] <= intervals[j][0]) {
                    if (ans[i] == -1) {
                        ans[i] = j;
                    } else if (intervals[ans[i]][0] > intervals[j][0]) {
                        ans[i] = j;
                    }
                }
            }
        }
        return ans;
    }
}
