package com.test.leetcode.page1.chapter20.t20;

import java.util.LinkedList;

/**
 * @ClassName: Solution20220126
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/1/26 16:37
 * @Version: 1.0
 */
public class Solution20220126 {

    public boolean isValid(String s) {
        LinkedList<Character> ll = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                ll.push(chars[i]);
            } else {
                if (ll.isEmpty()) {
                    return false;
                }
                Character c = ll.pop();
                if (c == null) {
                    return false;
                } else if ((chars[i] == ')' && c != '(')
                        || (chars[i] == ']' && c != '[')
                        || (chars[i] == '}' && c != '{')) {
                    return false;
                }
            }
        }
        return ll.isEmpty();
    }
}
