package com.test.leetcode.page5.chapter430.t439;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: Solution20230609
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/9 09:23
 * @Version: 1.0
 */
public class Solution20230609 {

    /**
     * 这个好好想想，应该不难，算了，不做了
     *
     * @param expression
     * @return
     */
    public String parseTernary(String expression) {
        Deque<Character> operator = new ArrayDeque<>();
        Deque<Character> value = new ArrayDeque<>();
        char[] array = expression.toCharArray();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            if (array[i] == '?' || array[i] == ':') {
                continue;
            }
            if (i + 1 < n) {
                if (array[i + 1] == '?') {
                    operator.push(array[i]);
                } else if (array[i + 1] == ':') {
                    value.push(array[i]);
                }
            }
        }
        return value.pop() + "";
    }
}
