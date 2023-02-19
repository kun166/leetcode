package com.test.leetcode.erery;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution1237
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/18 7:33
 * @Version: 1.0
 */
public class Solution1237 {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                int value = customfunction.f(i, j);
                if (value == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                } else if (value > z) {
                    break;
                }
            }
        }
        return ans;
    }

    interface CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y);
    }
}


