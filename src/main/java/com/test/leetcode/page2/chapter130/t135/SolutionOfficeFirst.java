package com.test.leetcode.page2.chapter130.t135;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-21 19:42
 */
public class SolutionOfficeFirst {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        // 从左侧遍历
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        // 从右侧遍历
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }
}
