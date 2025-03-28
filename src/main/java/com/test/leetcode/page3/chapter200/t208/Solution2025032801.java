package com.test.leetcode.page3.chapter200.t208;

/**
 * @ClassName: Solution2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 08:53
 * @Version: 1.0
 */
public class Solution2025032801 {

    /**
     * 33ms	击败79.31%
     * 54.09MB	击败92.24%
     */
    class Trie {

        TrieCache cache;


        public Trie() {
            cache = new TrieCache();
        }

        public void insert(String word) {
            TrieCache trieCache = cache;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (trieCache.caches[index] == null) {
                    trieCache.caches[index] = new TrieCache();
                }
                trieCache = trieCache.caches[index];
            }
            trieCache.end = true;
        }

        public boolean search(String word) {
            TrieCache trieCache = cache;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (trieCache.caches[index] == null)
                    return false;
                trieCache = trieCache.caches[index];
            }
            return trieCache.end;
        }

        public boolean startsWith(String prefix) {
            TrieCache trieCache = cache;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (trieCache.caches[index] == null)
                    return false;
                trieCache = trieCache.caches[index];
            }
            return true;
        }

        class TrieCache {
            TrieCache[] caches = new TrieCache[26];
            boolean end;
        }
    }
}
