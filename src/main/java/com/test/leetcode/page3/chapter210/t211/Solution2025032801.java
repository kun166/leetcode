package com.test.leetcode.page3.chapter210.t211;

/**
 * @ClassName: Solution2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 11:03
 * @Version: 1.0
 */
public class Solution2025032801 {

    /**
     * 220ms	击败38.94%
     * 99.64MB	击败20.32%
     */
    class WordDictionary {

        Trie trie;

        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
//            addWord(word, 0, trie);
            Trie t = trie;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (t.tries[index] == null) {
                    t.tries[index] = new Trie();
                }
                t = t.tries[index];
            }
            t.end = true;
        }

        public boolean search(String word) {
            return search(word, 0, trie);
        }

        boolean search(String word, int index, Trie trie) {
            if (index == word.length())
                return trie.end;
            if (word.charAt(index) == '.') {
                boolean ans = false;
                for (Trie t : trie.tries) {
                    ans = ans || (t != null && search(word, index + 1, t));
                }
                return ans;
            } else {
                int i = word.charAt(index) - 'a';
                if (trie.tries[i] == null)
                    return false;
                return search(word, index + 1, trie.tries[i]);
            }
        }

//        void addWord(String word, int index, Trie trie) {
//            if (index == word.length()) {
//                trie.end = true;
//                return;
//            }
//            if (word.charAt(index) == '.') {
//                for (int i = 0; i < 26; i++) {
//                    if (trie.tries[i] == null) {
//                        trie.tries[i] = new Trie();
//                    }
//                }
//                for (Trie t : trie.tries) {
//                    addWord(word, index + 1, t);
//                }
//            } else {
//                int i = word.charAt(index) - 'a';
//                if (trie.tries[index] == null) {
//                    trie.tries[index] = new Trie();
//                }
//                addWord(word, index + 1, trie.tries[index]);
//            }
//        }


        class Trie {
            Trie[] tries = new Trie[26];
            boolean end;
        }
    }
}
