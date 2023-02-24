package com.test.leetcode.page3.chapter210.t212;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230223
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/23 09:48
 * @Version: 1.0
 */
public class SolutionFirst20230223 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findWords(new char[][]{
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}
                },
                new String[]{"oath", "pea", "eat", "rain"})));
    }

    boolean find = false;

    /**
     * 感觉要超时啊
     * 呃，果然超时了啊
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        boolean[][] valid = new boolean[board.length][board[0].length];
        for (String word : words) {
            findWord(board, word, ans, valid);
        }
        return ans;
    }


    public void findWord(char[][] board,
                         String word,
                         List<String> ans,
                         boolean[][] valid) {
        find = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (find) {
                        return;
                    }
                    dfs(board, word, ans, valid, 0, j, i);
                }
            }
        }
    }

    public void dfs(char[][] board,
                    String word,
                    List<String> ans,
                    boolean[][] valid,
                    int index,
                    int x,
                    int y) {
        if (find || y < 0 || x < 0 || y >= board.length || x >= board[0].length || valid[y][x]) {
            return;
        }
        if (board[y][x] == word.charAt(index)) {
            if (index == word.length() - 1) {
                find = true;
                ans.add(word);
                return;
            }
            valid[y][x] = true;
            dfs(board, word, ans, valid, index + 1, x + 1, y);
            dfs(board, word, ans, valid, index + 1, x - 1, y);
            dfs(board, word, ans, valid, index + 1, x, y + 1);
            dfs(board, word, ans, valid, index + 1, x, y - 1);
            valid[y][x] = false;
        }
    }
}
