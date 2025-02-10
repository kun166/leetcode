package com.test.leetcode.page1.chapter0.t6;

import java.util.ArrayList;
import java.util.List;

/**
 * 唉，实现的非常精妙
 *
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-11 15:41
 */
public class OfficialSolution {

    public String convert(String s, int numRows) {

        // 如果是一行的话，直接返回
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        // 当前行？
        int curRow = 0;
        // 向下走
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            // 第一行或者是倒数第一行的时候，就转向
            if (curRow == 0 || curRow == numRows - 1)
                goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
