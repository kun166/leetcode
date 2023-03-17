package com.test.leetcode.page3.chapter250.t256;

/**
 * @ClassName: Solution20230317
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/17 09:30
 * @Version: 1.0
 */
public class SolutionFirst20230317 {

    /**
     * 这题感觉又是一个动态规划题
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了75%的用户
     * 通过测试用例：100 / 100
     *
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        int red = 0, blue = 0, green = 0;
        for (int i = 0; i < costs.length; i++) {
            // 当前房子粉刷成红色的的成本
            int newRed = Math.min(blue, green) + costs[i][0];
            // 当前房子粉刷成蓝色的的成本
            int newBlue = Math.min(red, green) + costs[i][1];
            // 当前房子粉刷成绿色的的成本
            green = Math.min(red, blue) + costs[i][2];
            red = newRed;
            blue = newBlue;
        }
        return Math.min(red, Math.min(blue, green));
    }
}
