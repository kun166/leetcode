package com.test.leetcode.page3.chapter200.t205;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20230220
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/20 09:36
 * @Version: 1.0
 */
public class Solution20230220 {


    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> left = new HashMap<>();
        Map<Character, Character> right = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (left.containsKey(s.charAt(i))) {
                if (!left.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            } else {
                if (right.containsKey(t.charAt(i))) {
                    return false;
                }
                left.put(s.charAt(i), t.charAt(i));
                right.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
