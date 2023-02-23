package com.test.leetcode.page3.chapter210.t211;

import org.junit.Test;

/**
 * @ClassName: Solution20230223
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/23 08:55
 * @Version: 1.0
 */
public class Solution20230223 {

    @Test
    public void test() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        dictionary.search("a");
        dictionary.search(".at");
        dictionary.addWord("bat");
        dictionary.search(".at");
        dictionary.search("an.");
        dictionary.search("a.d.");
        dictionary.search("b.");
        dictionary.search("a.d");
        dictionary.search(".");
    }

    class WordDictionary {
        WordDictionary[] children = new WordDictionary[26];
        boolean isEnd;

        public WordDictionary() {

        }

        public void addWord(String word) {
            WordDictionary dictionary = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (dictionary.children[index] == null) {
                    dictionary.children[index] = new WordDictionary();
                }
                dictionary = dictionary.children[index];
            }
            dictionary.isEnd = true;
        }

        /**
         * 感觉需要递归
         *
         * @param word
         * @return
         */
        public boolean search(String word) {
            return search(word, this, 0);
        }

        public boolean search(String word, WordDictionary dictionary, int index) {
            char c = word.charAt(index);
            if (c == '.') {
                boolean find = false;
                for (WordDictionary child : dictionary.children) {
                    if (child == null) {
                        continue;
                    }
                    if (index == word.length() - 1 && child.isEnd) {
                        return true;
                    }
                    if (index < word.length() - 1) {
                        find = find || search(word, child, index + 1);
                    }
                }
                return find;
            } else {
                int i = c - 'a';
                WordDictionary child = dictionary.children[i];
                if (child == null) {
                    return false;
                }
                if (index == word.length() - 1) {
                    return child.isEnd;
                }
                if (index < word.length() - 1) {
                    return search(word, child, index + 1);
                }
                return false;
            }
        }
    }
}
