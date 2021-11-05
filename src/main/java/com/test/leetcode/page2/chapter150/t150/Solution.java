package com.test.leetcode.page2.chapter150.t150;

import org.junit.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-03 19:50
 */
public class Solution {

    Set<String> set = new HashSet() {
        {
            add("+");
            add("-");
            add("*");
            add("/");
        }
    };

    @Test
    public void test() {
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String s : tokens) {
            if (set.contains(s)) {
                // 运算符
                int second = deque.pop();
                int first = deque.pop();
                if (s.equals("+")) {
                    deque.push(first + second);
                } else if (s.equals("-")) {
                    deque.push(first - second);
                } else if (s.equals("*")) {
                    deque.push(first * second);
                } else if (s.equals("/")) {
                    deque.push(first / second);
                }
            } else {
                deque.push(Integer.parseInt(s));
            }
        }
        return deque.pop();
    }
}
