package com.test.leetcode.page2.chapter110.t119;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialThird20230126
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 9:36
 * @Version: 1.0
 */
public class OfficialThird20230126 {

    /**
     * 这种解法不错。虽然没看懂
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
