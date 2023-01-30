package com.test.leetcode.page2.chapter130.t135;

import org.junit.Test;

/**
 * @ClassName: Solution20230130
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/30 15:38
 * @Version: 1.0
 */
public class Solution20230130 {

    @Test
    public void test() {
        System.out.println(candy(new int[]{1,2,2}));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        // 从左边算，需要发放的糖果数
        int[] left = new int[n];
        // 从右边算，需要发放的糖果数
        int[] right = new int[n];
        // 从左边发
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                //评分高，多发一颗
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        // 从右边发
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
