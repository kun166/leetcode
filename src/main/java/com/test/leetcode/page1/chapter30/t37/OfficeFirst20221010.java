package com.test.leetcode.page1.chapter30.t37;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficeFirst20221010
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/10 16:43
 * @Version: 1.0
 */
public class OfficeFirst20221010 {
    // 要分别弄清楚这几个boolean数组的含义
    // 记录行。第一个位置记录行数，第二个位置记录该行0-9已经有哪些数字已经填充了
    private boolean[][] line = new boolean[9][9];
    // 记录列
    private boolean[][] column = new boolean[9][9];
    // 记录方格
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    // 记录未填充的数
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        // 初始化
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    // 如果未填充，则放入spaces里面
                    spaces.add(new int[]{i, j});
                } else {
                    // 行，列，方格等三个地方记录已经填充
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            // 说明未填充的地方都已经填充了
            valid = true;
            return;
        }
        // 遍历未填充的地方
        int[] space = spaces.get(pos);
        // 拿到这个未填充的数的横纵坐标
        int i = space[0], j = space[1];
        // 每一个未填充的空格，都尝试0-9走一遍
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
