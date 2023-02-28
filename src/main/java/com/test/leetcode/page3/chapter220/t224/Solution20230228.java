package com.test.leetcode.page3.chapter220.t224;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20230228
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/28 20:37
 * @Version: 1.0
 */
public class Solution20230228 {

    @Test
    public void test() {
//        String s = " 2";
//        System.out.println(calculate(s, 0, s.length() - 1));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {
        // 记录左括号的下标
        Deque<Integer> deque = new LinkedList<>();
        int left = 0, right = s.length() - 1, l = -1, r = -1;
        int current = 0;
//        StringBuilder builder = new StringBuilder();
//        builder.
        while (left <= right) {
            char c = s.charAt(left);
            if (c == '(') {
                deque.offer(left);
            } else if (c == ')') {
                int index = deque.pop();
                if (current == 0) {
                    current = calculate(s, index + 1, left - 1);
                } else {
                    String str = s.substring(index + 1, l) + current + s.substring(r, left - 1);
                    current = calculate(str, 0, str.length() - 1);
                }
                l = index - 1;
                r = left + 1;
            }
            left++;
        }
        if (l == -10) {
            return calculate(s, 0, s.length() - 1);
        } else if (l == -1) {
            // 开头就是'('
            return current;
        }
        String str = s.substring(0, l) + current + (r < s.length() ? s.substring(r) : "");
        return calculate(str, 0, str.length());
    }

    /**
     * 不带括号的计算结果
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    public int calculate(String s, int start, int end) {
        boolean less = false;
        int result = 0, current = 0;
        while (start <= end) {
            char c = s.charAt(start++);
            if (c == ' ') {
                continue;
            }
            if (c == '+' || c == '-') {
                result = less ? result - current : result + current;
                less = c == '-';
                current = 0;
            } else {
                current = current * 10 + c - '0';
            }
        }
        return less ? result - current : result + current;
    }
}
