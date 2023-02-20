package com.test.leetcode.page3.chapter200.t205;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Official20230220
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/20 09:56
 * @Version: 1.0
 */
public class Official20230220 {

    /**
     * 方法一：哈希表
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
