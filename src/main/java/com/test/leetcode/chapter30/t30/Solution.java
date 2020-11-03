package com.test.leetcode.chapter30.t30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-27 10:13
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        // 一个单词的长度
        int one_word = words[0].length();
        // 匹配单词数组的长度
        int word_num = words.length;
        // 匹配单词的总长度
        int all_len = one_word * word_num;

        for (String word : words) {
            // word出现的次数？
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            // 截取匹配单词总长度个字符串
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                // 每次循环一个单词的长度
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            // 运用hashmap的equals对比
            if (map.equals(tmp_map)) res.add(i);
        }
        return res;
    }

    public List<Integer> findSubstringTwo(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        // 一个单词的长度
        int one_word = words[0].length();
        // 单词数组的长度
        int word_num = words.length;
        // 总的单词的长度
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {
            // 采用滑动方案。right以一个单词的长度向前走，如果该单词和words中单词不匹配，则left向前走，直到去掉该单词。
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s.length()) {
                // 以一个单词的长度向后遍历。
                String w = s.substring(right, right + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                right += one_word;
                count++;
                while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                    String t_w = s.substring(left, left + one_word);
                    count--;
                    tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                    left += one_word;
                }
                if (count == word_num) res.add(left);

            }
        }

        return res;
    }
}
