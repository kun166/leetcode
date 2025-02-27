package com.test.leetcode.page1.chapter50.t59;

/**
 * @ClassName: Solution20250227
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/27 10:11
 * @Version: 1.0
 */
public class Solution2025022701 {

    /**
     * 这种题，最简单的方式就是四边法吧
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int number = 0;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int[][] ans = new int[n][n];
        while (true) {
            // 退出条件
            if (top > bottom || left > right) {
                return ans;
            }
            // 从上左到上右
            for (int i = left; i <= right; i++) {
                ans[top][i] = ++number;
            }
            top++;
            // 从右上到右下
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = ++number;
            }
            right--;
            // 从下右到下左
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = ++number;
            }
            bottom--;
            // 从左下到左上
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = ++number;
            }
            left++;
        }
    }
}
