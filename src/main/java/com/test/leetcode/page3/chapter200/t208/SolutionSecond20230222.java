package com.test.leetcode.page3.chapter200.t208;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SolutionSecond20230222
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/22 16:52
 * @Version: 1.0
 */
public class SolutionSecond20230222 {

    class Trie {
        private Map<Character, Trie> children;
        private boolean isEnd;

        public Trie() {
            children = new HashMap<>();
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                node.children.putIfAbsent(ch, new Trie());
                node = node.children.get(ch);
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                node = node.children.get(ch);
                if (node == null) {
                    return null;
                }
            }
            return node;
        }
    }
}
