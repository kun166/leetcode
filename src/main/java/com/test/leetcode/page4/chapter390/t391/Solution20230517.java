package com.test.leetcode.page4.chapter390.t391;

import org.junit.Test;

/**
 * @ClassName: Solution20230517
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/17 09:26
 * @Version: 1.0
 */
public class Solution20230517 {

    @Test
    public void test() {
        System.out.println(isRectangleCover(new int[][]{{0, 0, 1, 1}, {0, 1, 3, 2}, {1, 0, 2, 2}}));
    }

    /**
     * 解法错误，唉
     *
     * @param rectangles
     * @return
     */
    public boolean isRectangleCover(int[][] rectangles) {
        int sum = 0;
        int x, y, a, b;
        x = y = Integer.MAX_VALUE;
        a = b = Integer.MIN_VALUE;
        for (int[] array : rectangles) {
            sum += (array[2] - array[0]) * (array[3] - array[1]);
            x = Math.min(x, array[0]);
            y = Math.min(y, array[1]);
            a = Math.max(a, array[2]);
            b = Math.max(b, array[3]);
        }
        return sum == (a - x) * (b - y);
    }
}
