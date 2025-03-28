package com.test.leetcode.page3.chapter210.t212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Solution2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 14:57
 * @Version: 1.0
 */
public class Solution2025032802 {

    /**
     * 678ms	击败24.68%
     * 46.94MB	击败12.71%
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        // 1,通过words初始化root
        for (String word : words) {
            Trie trie = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (trie.children[index] == null) {
                    trie.children[index] = new Trie();
                }
                trie = trie.children[index];
            }
            trie.end = true;
        }
        // 2,遍历board
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        boolean[][] pass = new boolean[board.length][board[0].length];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, pass, set, builder, i, j, root);
            }
        }
        ans.addAll(set);
        return ans;
    }

    void backtrack(char[][] board,
                   boolean[][] pass,
                   Set<String> set,
                   StringBuilder builder,
                   int row,
                   int column,
                   Trie trie) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || pass[row][column]) {
            return;
        }
        if (trie.children[board[row][column] - 'a'] == null) {
            return;
        }
        // 1,赋值
        Trie child = trie.children[board[row][column] - 'a'];
        pass[row][column] = true;
        builder.append(board[row][column]);
        if (child.end) {
            set.add(builder.toString());
        }
        // 2,递归
        backtrack(board, pass, set, builder, row - 1, column, child);
        backtrack(board, pass, set, builder, row + 1, column, child);
        backtrack(board, pass, set, builder, row, column - 1, child);
        backtrack(board, pass, set, builder, row, column + 1, child);
        // 3,回溯
        pass[row][column] = false;
        builder.deleteCharAt(builder.length() - 1);
    }

    class Trie {
        Trie[] children = new Trie[26];
        boolean end;
    }
}
