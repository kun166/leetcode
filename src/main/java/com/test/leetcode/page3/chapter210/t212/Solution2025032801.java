package com.test.leetcode.page3.chapter210.t212;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 14:57
 * @Version: 1.0
 */
public class Solution2025032801 {

    /**
     * 这题怎么那么像前缀树呢
     * <p>
     * 输入:
     * board =
     * {{'o','a','b','n'},
     * {'o','t','a','e'},
     * {'a','h','k','r'},
     * {'a','f','l','v'}}
     * <p>
     * words =
     * {"oa","oaa"}
     * <p>
     * 输出:["oa","oa","oaa"]
     * 预期结果:["oa","oaa"]
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
        boolean[][] pass = new boolean[board.length][board[0].length];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, pass, ans, builder, i, j, root);
            }
        }
        return ans;
    }

    void backtrack(char[][] board,
                   boolean[][] pass,
                   List<String> ans,
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
            ans.add(builder.toString());
        }
        // 2,递归
        backtrack(board, pass, ans, builder, row - 1, column, child);
        backtrack(board, pass, ans, builder, row + 1, column, child);
        backtrack(board, pass, ans, builder, row, column - 1, child);
        backtrack(board, pass, ans, builder, row, column + 1, child);
        // 3,回溯
        pass[row][column] = false;
        builder.deleteCharAt(builder.length() - 1);
    }

    class Trie {
        Trie[] children = new Trie[26];
        boolean end;
    }
}
