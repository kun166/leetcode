package com.test.leetcode.page1.chapter50.t51;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution20221112 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(solveNQueens(4)));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            position[i] = -1;
        }
        solveNQueens(n, ans, 0, position);
        return ans;
    }

    public void solveNQueens(int n, List<List<String>> ans, int line, int[] position) {
        if (line == n) {
            List<String> list = new ArrayList<>();
            StringBuilder builder;
            for (int i = 0; i < n; i++) {
                builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == position[i]) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                list.add(builder.toString());
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(n, line, i, position)) {
                position[line] = i;
                solveNQueens(n, ans, line + 1, position);
                position[line] = -1;
            }
        }
    }

    public boolean valid(int n, int line, int column, int[] position) {
        // line不用判断了，只判断column就好
        for (int i = 0; i < n; i++) {
            if (column == position[i]) {
                return false;
            }
        }
        // 对角线怎么求啊……
        int l = line - 1, c = column - 1;
        while (l >= 0 && c >= 0) {
            // 正对角线向上
            if (position[l] == c) {
                return false;
            }
            l--;
            c--;
        }
        l = line + 1;
        c = column + 1;
        while (l < n && c < n) {
            // 正对角线向下
            if (position[l] == c) {
                return false;
            }
            l++;
            c++;
        }

        l = line - 1;
        c = column + 1;
        while (l >= 0 && c < n) {
            // 斜对角线向上
            if (position[l] == c) {
                return false;
            }
            l--;
            c++;
        }

        l = line + 1;
        c = column - 1;
        while (l < n && c >= 0) {
            // 斜对角线向下
            if (position[l] == c) {
                return false;
            }
            l++;
            c--;
        }
        return true;
    }
}
