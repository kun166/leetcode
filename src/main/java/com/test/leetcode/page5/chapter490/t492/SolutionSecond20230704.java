package com.test.leetcode.page5.chapter490.t492;

/**
 * @ClassName: SolutionSecond20230704
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/4 15:50
 * @Version: 1.0
 */
public class SolutionSecond20230704 {

    /**
     * 执行用时：37 ms, 在所有 Java 提交中击败了22.01%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了93.16%的用户
     * 通过测试用例：52 / 52
     *
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int ans = (int) Math.sqrt(area);
        if (ans * ans == area) {
            return new int[]{ans, ans};
        }
        for (int i = ans + 1; i < area; i++) {
            if (area % i == 0) {
                return new int[]{i, area / i};
            }
        }
        return new int[]{area, 1};
    }
}
