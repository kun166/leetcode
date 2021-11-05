package com.test.leetcode.page2.chapter140.t140;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-26 19:34
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"}))));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Map<Integer, Set<String>> map = new HashMap<>();
        int wordMaxLength = 0;
        for (String word : wordDict) {
            map.putIfAbsent(word.length(), new HashSet<>());
            map.get(word.length()).add(word);
            wordMaxLength = Math.max(wordMaxLength, word.length());
        }
        List<String> list = new ArrayList<>();
        wordBreak(ans, s, 0, wordMaxLength, map, list);
        return ans;
    }

    public void wordBreak(List<String> ans,
                          String s,
                          int index,
                          int wordMaxLength,
                          Map<Integer, Set<String>> map,
                          List<String> list) {
        if (index >= s.length()) {
            ans.add(String.join(" ", list));
            return;
        }
        for (int i = 1; i <= wordMaxLength && index + i <= s.length(); i++) {
            if (map.containsKey(i) && map.get(i).contains(s.substring(index, index + i))) {
                list.add(s.substring(index, index + i));
                wordBreak(ans, s, index + i, wordMaxLength, map, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
