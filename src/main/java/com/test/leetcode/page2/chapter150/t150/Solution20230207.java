package com.test.leetcode.page2.chapter150.t150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20230207
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/7 09:05
 * @Version: 1.0
 */
public class Solution20230207 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = deque.pop(), a = deque.pop();
                if (s.equals("+")) {
                    deque.push(a + b);
                } else if (s.equals("-")) {
                    deque.push(a - b);
                } else if (s.equals("*")) {
                    deque.push(a * b);
                } else {
                    deque.push(a / b);
                }
            } else {
                deque.push(Integer.valueOf(s));
            }
        }
        return deque.pop();
    }
}
