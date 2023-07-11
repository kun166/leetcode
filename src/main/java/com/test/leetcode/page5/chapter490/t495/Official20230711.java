package com.test.leetcode.page5.chapter490.t495;

/**
 * @ClassName: Official20230711
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/11 09:34
 * @Version: 1.0
 */
public class Official20230711 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：44.5 MB, 在所有 Java 提交中击败了5.18%的用户
     * 通过测试用例：40 / 40
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int expired = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            if (timeSeries[i] >= expired) {
                ans += duration;
            } else {
                ans += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration;
        }
        return ans;
    }
}
