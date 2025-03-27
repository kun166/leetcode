package com.test.leetcode.page3.chapter200.t205;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution2025032701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/27 11:41
 * @Version: 1.0
 */
public class Solution2025032701 {

    /**
     * 21ms	击败45.94%
     * 41.55MB	击败76.95%
     * <p>
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> left = new HashMap<>();
        Map<Character, Character> right = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (left.containsKey(s.charAt(i))) {
                if (left.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                left.put(s.charAt(i), t.charAt(i));
            }

            if (right.containsKey(t.charAt(i))) {
                if (right.get(t.charAt(i)) != s.charAt(i))
                    return false;
            } else {
                right.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
