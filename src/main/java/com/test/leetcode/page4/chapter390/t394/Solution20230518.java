package com.test.leetcode.page4.chapter390.t394;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20230518
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/18 09:15
 * @Version: 1.0
 */
public class Solution20230518 {

    @Test
    public void test() {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了75.12%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了63.71%的用户
     * 通过测试用例：34 / 34
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 数字，直接扔队列里
                deque.push(c);
            } else if (c == '[') {
                deque.push(c);
            } else if (c == ']') {
                StringBuilder str = new StringBuilder();
                char ch = deque.pop();
                while (ch >= 'a' && ch <= 'z') {
                    str.append(ch);
                    ch = deque.pop();
                }
                str.reverse();
                // 剩下的是数字了
                StringBuilder number = new StringBuilder();
                while (!deque.isEmpty() && Character.isDigit(deque.peek())) {
                    number.append(deque.pop());
                }
                int count = Integer.parseInt(number.reverse().toString());
                StringBuilder strTotal = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    strTotal.append(str);
                }
                if (deque.isEmpty()) {
                    ans.append(strTotal);
                } else {
                    for (int i = 0; i < strTotal.length(); i++) {
                        deque.push(strTotal.charAt(i));
                    }
                }
            } else {
                // 字母
                if (deque.isEmpty()) {
                    ans.append(c);
                } else {
                    deque.push(c);
                }
            }
        }
        return ans.toString();
    }
}
