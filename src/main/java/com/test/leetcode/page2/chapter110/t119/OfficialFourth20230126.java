package com.test.leetcode.page2.chapter110.t119;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFourth20230126
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 9:39
 * @Version: 1.0
 */
public class OfficialFourth20230126 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}
