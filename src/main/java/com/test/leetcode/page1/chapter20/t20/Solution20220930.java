package com.test.leetcode.page1.chapter20.t20;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20220930
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/9/30 10:59
 * @Version: 1.0
 */
public class Solution20220930 {

    @Test
    public void test() {
        System.out.println(isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                deque.push(c);
            } else {
                Character copy = null;
                if (c == ')') {
                    copy = '(';
                } else if (c == '}') {
                    copy = '{';
                } else if (c == ']') {
                    copy = '[';
                }
                if (deque.isEmpty() || copy != deque.pop()) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
