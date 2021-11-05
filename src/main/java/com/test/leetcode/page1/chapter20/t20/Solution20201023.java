package com.test.leetcode.page1.chapter20.t20;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-23 15:40
 */
public class Solution20201023 {

    @Test
    public void test() {
        System.out.println(isValid("()"));
        System.out.println(isValid("[)"));
        System.out.println(isValid(""));
        System.out.println(isValid(")"));
    }

    Map<Character, Character> map = new HashMap<>();

    {
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }

    public boolean isValid(String s) {

        List<Character> l = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (!l.isEmpty() && l.get(l.size() - 1).equals(map.get(c))) {
                    l.remove(l.size() - 1);
                } else {
                    return false;
                }
            } else {
                l.add(c);
            }
        }
        return l.isEmpty();
    }
}
