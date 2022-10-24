package com.test.leetcode.page1.chapter20.t20;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: Solution20221024
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/24 11:11
 * @Version: 1.0
 */
public class Solution20221024 {

    Map<Character, Character> map = new HashMap() {
        {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }
    };

    @Test
    public void test() {
        System.out.println(isValid("()"));
    }


    public boolean isValid(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (list.isEmpty() || !map.get(c).equals(list.remove(list.size() - 1))) {
                    return false;
                }
            } else {
                list.add(c);
            }
        }
        return list.isEmpty();
    }
}
