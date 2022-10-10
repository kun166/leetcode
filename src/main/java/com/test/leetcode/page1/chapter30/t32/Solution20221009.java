package com.test.leetcode.page1.chapter30.t32;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20221009
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/9 17:40
 * @Version: 1.0
 */
public class Solution20221009 {

    @Test
    public void test() {
        System.out.println(longestValidParentheses("()(())"));
    }

    public int longestValidParentheses(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        // 1,先寻找()的
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    map.put(i, i - 1);
                } else {
                    if (map.containsKey(i - 1)) {
                        int pre = map.get(i - 1);
                        if (pre - 1 >= 0 && '(' == s.charAt(pre - 1)) {
                            map.put(i, pre - 1);
                        }
                    }
                }

                if (map.containsKey(i)) {
                    int pre = map.get(i) - 1;
                    if (map.containsKey(pre)) {
                        map.put(i, map.get(pre));
                    }
                }
            }
            max = map.containsKey(i) ? Math.max(max, i - map.get(i) + 1) : max;
        }
        return max;
    }
}
