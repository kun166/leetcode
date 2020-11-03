package com.test.leetcode.chapter20.t20;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-16 19:49
 */
public class Solution {

    Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }
    };

    @Test
    public void test() {
        System.out.println(match("") + ":true");
        System.out.println(match("()") + ":true");
        System.out.println(match("()[]{}") + ":true");
        System.out.println(match("(]") + ":false");
        System.out.println(match("([)]") + ":false");
        System.out.println(match("{[]}") + ":true");
        System.out.println(match("{[") + ":false");
    }


    public boolean match(String str) {
        Stack<Character> stack = new Stack<>();
        char[] array = str.toCharArray();
        for (char c : array) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !stack.pop().equals(map.get(c))) return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
