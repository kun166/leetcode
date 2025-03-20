package com.test.leetcode.page2.chapter140.t140;

import java.util.*;

/**
 * @ClassName: Solution2025032001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 08:44
 * @Version: 1.0
 */
public class Solution2025032002 {

    /**
     * 5ms	击败24.64%
     * 41.09MB	击败30.22%
     * <p>
     * 呃，呃，呃……
     * 这种方式居然更慢……我直呼好家伙
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (String str : wordDict) {
            set.add(str);
            if (!list.contains(str.length()))
                list.add(str.length());
        }
        Collections.sort(list);
        return backtrack(s, set, map, list, 0);
    }


    public List<String> backtrack(String s, Set<String> set, Map<Integer, List<String>> map, List<Integer> list, int index) {
        List<String> l = new ArrayList<>();
        for (int length : list) {
            String str;
            if (index + length > s.length()) {
                break;
            }
            if (!set.contains(str = s.substring(index, index + length))) {
                continue;
            }
            if (index + length < s.length()) {
                List<String> ans;
                if (map.containsKey(index + length)) {
                    ans = map.get(index + length);
                } else {
                    ans = backtrack(s, set, map, list, index + length);
                }
                for (String ss : ans) {
                    if (index == 0) {
                        l.add(str + ss);
                    } else {
                        l.add(" " + str + ss);
                    }
                }
            } else if (index + length == s.length()) {
                if (index == 0)
                    l.add(str);
                else
                    l.add(" " + str);
            }

        }
        map.put(index, l);
        return l;
    }
}
