package com.test.leetcode.page2.chapter130.t130;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-16 15:46
 */
public class SolutionOfficeTwo {

    // {x,y}坐标的上下左右四个点
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
        // 行
        int n = board.length;
        if (n == 0) {
            return;
        }
        // 列
        int m = board[0].length;
        // 记录该坐标是'O'且是联通的，需要探测前后左右四个点位
        // 遍历四个边
        Queue<int[]> queue = new LinkedList<>();
        //左右两个边
        for (int i = 0; i < n; i++) {
            // 左边
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            // 右边
            if (board[i][m - 1] == 'O') {
                queue.offer(new int[]{i, m - 1});
            }
        }
        // 上下两个边
        for (int i = 1; i < m - 1; i++) {
            // 上边
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
            }
            // 下边
            if (board[n - 1][i] == 'O') {
                queue.offer(new int[]{n - 1, i});
            }
        }
        while (!queue.isEmpty()) {
            // 从队列上部取
            int[] cell = queue.poll();
            // x,y两个轴坐标
            int x = cell[0], y = cell[1];
            // 借助board记录，不用额外记录，哪些元素已经被遍历过了
            // 联通的修改为'A'
            board[x][y] = 'A';
            for (int i = 0; i < 4; i++) {
                // 前后左右四个点
                int mx = x + dx[i], my = y + dy[i];
                // 如果坐标越界，或者该坐标不为'O',则不处理
                if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                    continue;
                }
                // 该坐标是'O'
                queue.offer(new int[]{mx, my});
            }
        }
        // 将联通的'A'修改为'O'，将非联通的'O'修改为'A'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
