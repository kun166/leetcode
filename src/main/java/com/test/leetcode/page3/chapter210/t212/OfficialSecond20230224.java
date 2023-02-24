package com.test.leetcode.page3.chapter210.t212;

import java.util.*;

/**
 * @ClassName: OfficialSecond20230224
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/24 09:18
 * @Version: 1.0
 */
public class OfficialSecond20230224 {

    /**
     * 方法二：删除被匹配的单词
     * 呃，这种方法居然是方法一的耗时的十分之一……
     */
    class Solution {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public List<String> findWords(char[][] board, String[] words) {
            // 初始化字典树
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            Set<String> ans = new HashSet<String>();
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    // 遍历每一个坐标
                    dfs(board, trie, i, j, ans);
                }
            }

            return new ArrayList<String>(ans);
        }

        public void dfs(char[][] board, Trie now, int i1, int j1, Set<String> ans) {
            // 没什么变化，这个地方和方法一一样
            if (!now.children.containsKey(board[i1][j1])) {
                return;
            }
            char ch = board[i1][j1];
            Trie nxt = now.children.get(ch);
            if (!"".equals(nxt.word)) {
                ans.add(nxt.word);
                // 找过一遍，就不再找第二遍了
                nxt.word = "";
            }

            // 这一步感觉和方法一区别也不大
            if (!nxt.children.isEmpty()) {
                board[i1][j1] = '#';
                for (int[] dir : dirs) {
                    int i2 = i1 + dir[0], j2 = j1 + dir[1];
                    if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                        dfs(board, nxt, i2, j2, ans);
                    }
                }
                board[i1][j1] = ch;
            }

            /**
             * 速度快，应该在这一步。
             * 当前nxt也访问过了。如果nxt就是最长的前缀了，就删除nxt
             */
            if (nxt.children.isEmpty()) {
                now.children.remove(ch);
            }
        }
    }

    class Trie {
        String word;
        Map<Character, Trie> children;
        boolean isWord;

        public Trie() {
            this.word = "";
            this.children = new HashMap<Character, Trie>();
        }

        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.word = word;
        }
    }

}
