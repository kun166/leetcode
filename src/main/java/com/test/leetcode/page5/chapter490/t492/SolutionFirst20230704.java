package com.test.leetcode.page5.chapter490.t492;

/**
 * @ClassName: Solution20230704
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/4 15:44
 * @Version: 1.0
 */
public class SolutionFirst20230704 {

    /**
     * 执行用时：378 ms, 在所有 Java 提交中击败了5.13%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了64.53%的用户
     * 通过测试用例：52 / 52
     *
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int ans = area;
        long start = area;
        while (start * start >= area) {
            if (area % start == 0) {
                ans = (int) start;
            }
            start--;
        }
        return new int[]{ans, area / ans};
    }
}
