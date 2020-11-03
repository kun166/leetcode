package com.test.leetcode.chapter40.t49;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-30 16:19
 */
public class Solution {

    @Test
    public void test() {
        List<List<String>> list = groupAnagrams(new String[]{"ddddddddddg", "dgggggggggg"});
        for (List<String> l : list) {
            System.out.println();
            for (String s : l) {
                System.out.print(s + ",");
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0)
            return ans;
        Map<Map<Character, Integer>, Integer> map = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> sMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }
            List<String> list = null;
            if (map.containsKey(sMap)) {
                list = ans.get(map.get(sMap));
            } else {
                list = new ArrayList<>();
                map.put(sMap, ans.size());
                ans.add(list);
            }
            list.add(s);
        }
        return ans;
    }
}
