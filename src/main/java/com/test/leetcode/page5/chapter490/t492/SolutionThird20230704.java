package com.test.leetcode.page5.chapter490.t492;

/**
 * @ClassName: SolutionThird20230704
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/4 15:58
 * @Version: 1.0
 */
public class SolutionThird20230704 {

    /**
     * 这个方法和二差不多，居然差这么多
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了93.16%的用户
     * 通过测试用例：52 / 52
     *
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (w > 0) {
            if (area % w == 0) {
                break;
            }
            w--;
        }
        return new int[]{area / w, w};
    }
}
