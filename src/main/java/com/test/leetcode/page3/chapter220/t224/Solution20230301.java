package com.test.leetcode.page3.chapter220.t224;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20230301
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/1 08:12
 * @Version: 1.0
 */
public class Solution20230301 {

    @Test
    public void test() {
//        String s = " 2";
//        System.out.println(calculate(s, 0, s.length() - 1));
        //System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        // System.out.println(calculate("-(1-(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("1 + 1"));
    }

    /**
     * 先脱括号吧
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        String str = remove(s);
        return calculate(str, 0, str.length() - 1);
    }

    /**
     * 脱括号
     *
     * @param s
     * @return
     */
    public String remove(String s) {
        // 记录括号前的正负号
        Deque<Boolean> deque = new LinkedList<>();
        boolean cLess = false;
        int start = 0;
        StringBuilder builder = new StringBuilder();
        while (start < s.length()) {
            char c = s.charAt(start);
            if (c == ' ') {
                start++;
                continue;
            }
            if (deque.isEmpty()) {
                // 在括号外面
                if (c == '+') {
                    builder.append(c);
                    cLess = false;
                } else if (c == '-') {
                    builder.append(c);
                    cLess = true;
                } else if (c == '(') {
                    deque.push(cLess);
                } else {
                    builder.append(c);
                }
            } else {
                // 在括号里面
                if (c == '+') {
                    cLess = deque.peek();
                    builder.append(cLess ? '-' : '+');
                } else if (c == '-') {
                    cLess = !deque.peek();
                    builder.append(cLess ? '-' : '+');
                } else if (c == '(') {
                    deque.push(cLess);
                } else if (c == ')') {
                    deque.pop();
                } else {
                    builder.append(c);
                }
            }
            start++;
        }
        return builder.toString();
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
