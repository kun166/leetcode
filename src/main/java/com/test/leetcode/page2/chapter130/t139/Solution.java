package com.test.leetcode.page2.chapter130.t139;

import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-26 15:45
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        Map<Integer, Set<String>> map = new HashMap<>();
        // 找出单词最大的长度
        int wordMaxLength = 0;
        for (String word : wordDict) {
            map.putIfAbsent(word.length(), new HashSet<>());
            map.get(word.length()).add(word);
            wordMaxLength = Math.max(wordMaxLength, word.length());
        }
        boolean[] f = new boolean[length + 1];
        f[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= wordMaxLength && i + j <= length; j++) {
                // 字符串长度
                if (i == 0) {
                    f[i + j] = f[i + j] || (map.get(j) != null && map.get(j).contains(s.substring(i, i + j)));
                } else {
                    f[i + j] = f[i + j] || (f[i] && map.get(j) != null && map.get(j).contains(s.substring(i, i + j)));
                }
            }
        }
        return f[length];
    }
}
