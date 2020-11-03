package com.test.leetcode.chapter20.t20;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-16 20:09
 */
public class OfficialSolution {

    @Test
    public void test() {
        System.out.println(isValid("") + ":true");
        System.out.println(isValid("()") + ":true");
        System.out.println(isValid("()[]{}") + ":true");
        System.out.println(isValid("(]") + ":false");
        System.out.println(isValid("([)]") + ":false");
        System.out.println(isValid("{[]}") + ":true");
        System.out.println(isValid("{[") + ":false");
    }

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
