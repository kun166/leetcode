package com.test.leetcode.chapter70.t76;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-12 10:53
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (tl > sl)
            return "";
        Map<Character, Integer> tMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int start = -1, end = -1, min = Integer.MAX_VALUE, sn = -1;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < sl; i++) {
            if (tMap.containsKey(s.charAt(i))) {
                sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
                //判断sMap是否符合要求。
                if (isMatch(sMap, tMap)) {
                    //寻找最小值
                    for (sn = sn + 1; sn < i; sn++) {
                        if (tMap.containsKey(s.charAt(sn))) {
                            sMap.put(s.charAt(sn), sMap.get(s.charAt(sn)) - 1);
                            if (!isMatch(sMap, tMap))
                                break;
                        }
                    }
                    if (i - sn + 1 < min) {
                        min = i - sn + 1;
                        start = sn;
                        end = i;
                    }
                }
            }
        }
        return start == -1 ? "" : s.substring(start, end + 1);
    }

    public boolean isMatch(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (entry.getValue() > sMap.getOrDefault(entry.getKey(), 0))
                return false;
        }
        return true;
    }
}
