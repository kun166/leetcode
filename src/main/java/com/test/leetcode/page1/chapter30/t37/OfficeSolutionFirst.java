package com.test.leetcode.page1.chapter30.t37;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficeSolutionFirst
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/14 15:51
 * @Version: 1.0
 */
public class OfficeSolutionFirst {

    // 行
    private boolean[][] line = new boolean[9][9];
    // 列
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        // 第一步，记录哪些已经填写了数字，哪些还没有填写数字
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    // 把没填写数字的记录下来
                    spaces.add(new int[]{i, j});
                } else {
                    // 记录哪些格子已经有数字
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    /**
     * 递归加回溯
     *
     * @param board
     * @param pos
     */
    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
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
