package com.test.leetcode.page3.chapter210.t212;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Solution20230223
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/23 09:48
 * @Version: 1.0
 */
public class SolutionSecond20230223 {

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

    /**
     * 呃，这个也超出时间限制了？
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        boolean[][] valid = new boolean[board.length][board[0].length];
        Set<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, valid, set, builder, j, i, 0);
            }
        }
        for (String word : words) {
            if (set.contains(word)) {
                ans.add(word);
            }
        }
        return ans;
    }


    public void dfs(char[][] board,
                    boolean[][] valid,
                    Set<String> set,
                    StringBuilder builder,
                    int x,
                    int y,
                    int index) {
        if (y < 0 || x < 0 || y >= board.length || x >= board[0].length || valid[y][x] || index >= 10) {
            return;
        }
        valid[y][x] = true;
        builder.append(board[y][x]);
        set.add(builder.toString());
        dfs(board, valid, set, builder, x + 1, y, index + 1);
        dfs(board, valid, set, builder, x - 1, y, index + 1);
        dfs(board, valid, set, builder, x, y + 1, index + 1);
        dfs(board, valid, set, builder, x, y - 1, index + 1);
        builder.deleteCharAt(builder.length() - 1);
        valid[y][x] = false;
    }
}
