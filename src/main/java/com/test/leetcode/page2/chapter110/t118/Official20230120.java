package com.test.leetcode.page2.chapter110.t118;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Official20230120
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/20 19:14
 * @Version: 1.0
 */
public class Official20230120 {

    /**
     * 这代码确实更简洁，更舒服
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
