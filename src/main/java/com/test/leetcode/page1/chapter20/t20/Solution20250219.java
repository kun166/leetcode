package com.test.leetcode.page1.chapter20.t20;

import java.util.LinkedList;

/**
 * @ClassName: Solution20250219
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/19 14:20
 * @Version: 1.0
 */
public class Solution20250219 {

    public boolean isValid(String s) {
        LinkedList<Character> ll = new LinkedList();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (ll.isEmpty() || ll.removeLast() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (ll.isEmpty() || ll.removeLast() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (ll.isEmpty() || ll.removeLast() != '{') {
                    return false;
                }
            } else {
                ll.add(c);
            }
        }
        return ll.isEmpty();
    }
}
