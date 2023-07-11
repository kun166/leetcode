package com.test.leetcode.page5.chapter490.t495;

/**
 * @ClassName: Solution20230711
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/11 09:27
 * @Version: 1.0
 */
public class Solution20230711 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了41.27%的用户
     * 内存消耗：44.4 MB, 在所有 Java 提交中击败了12.20%的用户
     * 通过测试用例：40 / 40
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = duration, n = timeSeries.length;
        for (int i = 1; i < n; i++) {
            ans += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return ans;
    }
}
