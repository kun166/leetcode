package com.test.leetcode.page1.chapter30.t32;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: Solution20221031
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/31 19:25
 * @Version: 1.0
 */
public class Solution20221031 {

    @Test
    public void test() {
        System.out.println(longestValidParentheses("()(()"));
    }

    public int longestValidParentheses(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == ')') {
                int left = i;
                if (s.charAt(i - 1) == '(') {
                    left = i - 1;
                } else if (map.containsKey(i - 1) && map.get(i - 1) > 0 && s.charAt(map.get(i - 1) - 1) == '(') {
                    left = map.get(i - 1) - 1;
                }
                if (left != i) {
                    if (map.containsKey(left - 1)) {
                        left = map.get(left - 1);
                    }
                    map.put(i, left);
                    max = Math.max(max, i - left + 1);
                }
            }
        }
        return max;
    }
}
