package com.test.leetcode.page3.chapter210.t212;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Other2025032801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/28 16:27
 * @Version: 1.0
 */
public class Other2025032801 {

    /**
     * 执行用时：24ms
     * 这个算法是在用时较少的提交答案里看的
     */
    public class Node {
        Node[] cld = new Node[26];
        int ct = 0;
        int wi = -1;

        public Node append(char c) {
            int idx = c - 'a';
            if (cld[idx] == null)
                cld[idx] = new Node();

            cld[idx].ct++;
            return cld[idx];
        }
    }

    List<String> res = new ArrayList<>();
    Node root = new Node();
    int[] ops = new int[]{0, 1, 0, -1, 0};

    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++)
            addWord(words[i], i);
        int n = board.length;
        int m = board[0].length;
        boolean[][] v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                extractWord(board, v, i, j, root, words);

        }

        return res;
    }

    public int extractWord(char[][] board, boolean[][] v, int r, int c, Node nd, String[] words) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
            return 0;
        if (v[r][c] || nd == null || nd.ct == 0)
            return 0;

        Node cn = nd.cld[board[r][c] - 'a'];
        if (cn == null || cn.ct == 0)
            return 0;
        v[r][c] = true;
        int ct = 0;
        for (int i = 0; i < ops.length - 1; i++)
            ct += extractWord(board, v, r + ops[i], c + ops[i + 1], cn, words);

        v[r][c] = false;
        if (cn.wi != -1) {
            res.add(words[cn.wi]);
            cn.wi = -1;
            ct++;
        }

        cn.ct -= ct;
        return ct;
    }

    public void addWord(String w, int idx) {
        char[] cs = w.toCharArray();
        Node nd = root;
        root.ct++;
        for (char c : cs)
            nd = nd.append(c);
        nd.wi = idx;
    }
}
