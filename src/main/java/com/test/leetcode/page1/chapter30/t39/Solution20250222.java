package com.test.leetcode.page1.chapter30.t39;

import org.junit.Test;

public class Solution20250222 {

    public int count;

    @Test
    public void testBacktrackFirst() {
        count = 0;
        backtrackFirst(5, 0);
        System.out.println(count);
    }

    @Test
    public void testBacktrackSecond() {
        count = 0;
        backtrackSecond(5, 0);
        System.out.println(count);
    }

    /**
     * 本类不是为了解这道题，而是研究递归-回溯的两种解法
     *
     * @param length 数组长度
     * @param index  当前数组坐标
     * @return
     */
    public void backtrackFirst(int length, int index) {
        if (index == length) {
            return;
        }
        count++;
        // 1,选择。模拟选择
        backtrackFirst(length, index + 1);
        // 2,不选。模拟不选
        backtrackFirst(length, index + 1);
    }

    public void backtrackSecond(int length, int index) {
        count++;
        for (int i = index; i < length; i++) {
            // 模拟挑选
            backtrackSecond(length, i + 1);
        }
    }
}
