package com.test.leetcode.page1.chapter30.t32;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: SolutionSecond20221101
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/1 19:52
 * @Version: 1.0
 */
public class Solution202211012t {
    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.push(i);
            } else {
                deque.pop();
                if (deque.isEmpty()) {
                    deque.push(i);
                }
                max = Math.max(max, i - deque.peek());
            }
        }
        return max;
    }
}
