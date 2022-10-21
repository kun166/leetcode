package com.test.leetcode.page1.chapter0.t3;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20221019
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/19 10:54
 * @Version: 1.0
 */
public class Solution20221019 {


    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            while (deque.contains(c)) {
                deque.pollLast();
            }
            deque.push(c);
            max = Math.max(max, deque.size());
        }
        return max;
    }
}
