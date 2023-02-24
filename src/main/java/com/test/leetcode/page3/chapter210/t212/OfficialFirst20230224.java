package com.test.leetcode.page3.chapter210.t212;

import java.util.*;

/**
 * @ClassName: OfficialFirst20230224
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/24 08:33
 * @Version: 1.0
 */
public class OfficialFirst20230224 {

    /**
     * 回溯 + 字典树
     */
    class Solution {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public List<String> findWords(char[][] board, String[] words) {
            Trie trie = new Trie();
            // 把所有的word都加入到字典树中
            for (String word : words) {
                trie.insert(word);
            }

            Set<String> ans = new HashSet<String>();
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    dfs(board, trie, i, j, ans);
                }
            }

            return new ArrayList<String>(ans);
        }

        public void dfs(char[][] board, Trie now, int i1, int j1, Set<String> ans) {
            // 如果当前的{i1,j1}坐标的char不在字典树中，直接退出，不再寻找了
            if (!now.children.containsKey(board[i1][j1])) {
                return;
            }
            char ch = board[i1][j1];
            // 根据坐标{i1,j1}的值，找到字典树的子树
            now = now.children.get(ch);
            if (!"".equals(now.word)) {
                // 用now.word !=null是不是更好一些？
                ans.add(now.word);
            }

            // 遍历过的坐标值用#替代，防止重复访问。
            board[i1][j1] = '#';
            for (int[] dir : dirs) {
                int i2 = i1 + dir[0], j2 = j1 + dir[1];
                if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                    dfs(board, now, i2, j2, ans);
                }
            }
            // 换回原来的值
            board[i1][j1] = ch;
        }
    }

    /**
     * 字典树，也可以说是字典树的变种
     */
    class Trie {
        // 这个地方用的秒，不用额外记录这个word是啥了
        String word;
        Map<Character, Trie> children;
        boolean isWord;

        public Trie() {
            // 其实我觉得用 word==null判断是不是更好一些？
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
