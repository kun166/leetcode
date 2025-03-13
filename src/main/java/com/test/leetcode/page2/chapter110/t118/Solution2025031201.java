package com.test.leetcode.page2.chapter110.t118;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025031201
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/12 16:12
 * @Version: 1.0
 */
public class Solution2025031201 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        List<Integer> second = null;
        while (--numRows > 0) {
            second = new ArrayList<>();
            second.add(1);
            for (int i = 0; i < first.size() - 1; i++) {
                second.add(first.get(i) + first.get(i + 1));
            }
            second.add(1);
            ans.add(second);
            first = second;
        }
        return ans;
    }
}
