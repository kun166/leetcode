package com.test.leetcode.page2.chapter130.t139;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: Solution20230131
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/31 16:06
 * @Version: 1.0
 */
public class SolutionFirst20230131 {

    boolean pass;

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak("leetcode", list));
    }

    /**
     * 呃，超时了，唉
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        pass = false;
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String str : wordDict) {
            map.putIfAbsent(str.length(), new HashSet<>());
            map.get(str.length()).add(str);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        wordBreak(s, 0, map, list);
        return pass;
    }

    public void wordBreak(String s, int index, Map<Integer, Set<String>> map, List<Integer> list) {
        if (pass) {
            return;
        }
        if (index >= s.length()) {
            pass = true;
            return;
        }
        for (int j = list.size() - 1; j >= 0; j--) {
            int length = list.get(j);
            if (index + length <= s.length() && map.get(length).contains(s.substring(index, index + length))) {
                wordBreak(s, index + length, map, list);
            }
        }
    }
}
