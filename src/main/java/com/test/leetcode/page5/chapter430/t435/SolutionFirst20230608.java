package com.test.leetcode.page5.chapter430.t435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Solution20230608
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/8 09:33
 * @Version: 1.0
 */
public class SolutionFirst20230608 {

    /**
     * dp?动态规划？
     * <p>
     * 执行用时：288 ms, 在所有 Java 提交中击败了5.10%的用户
     * 内存消耗：93.6 MB, 在所有 Java 提交中击败了98.07%的用户
     * 通过测试用例：58 / 58
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        // dp[i]表示前i个区间，最少删除个数
        // 明显dp[0]=dp[1]=0
        int[] dp = new int[n + 1];
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        for (int i = 1; i < n; i++) {
            // 有三种选择。第一，当前区间和上一个区间没有重叠,dp[i]=dp[i-1]
            // 有重叠。第二，删除当前区间,dp[i]=dp[i-1]+1
            // 有重叠，第三，不删除当前区间
            if (intervals[i][0] >= intervals[i - 1][1]) {
                // 不需要删除
                dp[i + 1] = dp[i];
            } else {
                // 删除当前区间
                dp[i + 1] = dp[i] + 1;
                // 不删除当前区间
                int j = i - 1;
                while (j >= 0 && intervals[j][1] > intervals[i][0]) {
                    j--;
                }
                dp[i + 1] = Math.min(dp[i + 1], i - j - 1 + dp[j + 1]);
            }
        }
        return dp[n];
    }
}
