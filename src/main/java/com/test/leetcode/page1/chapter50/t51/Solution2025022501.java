package com.test.leetcode.page1.chapter50.t51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution2025022501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/25 17:30
 * @Version: 1.0
 */
public class Solution2025022501 {

    /**
     * 尝试下递归-回溯方法吧
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] array = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(array[i], '.');
        }
        backtrack(ans, array, 0);
        return ans;
    }

    /**
     * @param ans
     * @param array
     * @param index 填充的行数
     */
    public void backtrack(List<List<String>> ans, char[][] array, int index) {
        if (index == array.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                list.add(new String(array[i]));
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            array[index][i] = 'Q';
            if (isQueen(array, index, i)) {
                backtrack(ans, array, index + 1);
            }
            array[index][i] = '.';
        }
    }

    public boolean isQueen(char[][] array, int row, int col) {
        // 1,行校验
        for (int i = 0; i < array.length; i++) {
            if (i != col && array[row][i] == 'Q') {
                return false;
            }
        }
        // 2,列校验
        for (int i = 0; i < array.length; i++) {
            if (i != row && array[i][col] == 'Q') {
                return false;
            }
        }
        // 3,对角线校验
        // 3.1,斜左上
        int cr = row, cc = col;
        while (--cr >= 0 && --cc >= 0) {
            if (array[cr][cc] == 'Q') {
                return false;
            }
        }
        // 3.2,斜右上
        cr = row;
        cc = col;
        while (--cr >= 0 && ++cc < array.length) {
            if (array[cr][cc] == 'Q') {
                return false;
            }
        }
        // 3.3,斜左下
        cr = row;
        cc = col;
        while (++cr < array.length && ++cc < array.length) {
            if (array[cr][cc] == 'Q') {
                return false;
            }
        }
        // 3.4,斜右下
        cr = row;
        cc = col;
        while (++cr < array.length && --cc >= 0) {
            if (array[cr][cc] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
