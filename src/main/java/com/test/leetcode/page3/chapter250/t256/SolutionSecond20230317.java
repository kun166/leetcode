package com.test.leetcode.page3.chapter250.t256;

/**
 * @ClassName: SolutionSecond20230317
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/17 09:45
 * @Version: 1.0
 */
public class SolutionSecond20230317 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了51.23%的用户
     * 通过测试用例：100 / 100
     *
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        int[] dp1 = new int[3];
        int[] dp2 = new int[3];
        for (int i = 0; i < costs.length; i++) {
            dp2[0] = Math.min(dp1[1], dp1[2]) + costs[i][0];
            dp2[1] = Math.min(dp1[0], dp1[2]) + costs[i][1];
            dp2[2] = Math.min(dp1[0], dp1[1]) + costs[i][2];
            // 这个地方直接dp1 = dp2翻车
            int[] dp = dp1;
            dp1 = dp2;
            dp2 = dp;
        }
        return Math.min(dp1[0], Math.min(dp1[1], dp1[2]));
    }
}
