package com.test.leetcode.page3.chapter200.t208;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution20230222
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/22 10:06
 * @Version: 1.0
 */
public class Solution20230222 {

    class Trie {
        private Set<String> search;
        private Set<String> startsWith;

        public Trie() {
            search = new HashSet<>();
            startsWith = new HashSet<>();
        }

        public void insert(String word) {
            search.add(word);
            for (int i = 1; i <= word.length(); i++) {
                startsWith.add(word.substring(0, i));
            }
        }

        public boolean search(String word) {
            return search.contains(word);
        }

        public boolean startsWith(String prefix) {
            return startsWith.contains(prefix);
        }
    }
}
