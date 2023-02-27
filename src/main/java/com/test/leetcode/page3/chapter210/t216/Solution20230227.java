package com.test.leetcode.page3.chapter210.t216;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230227
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/27 20:05
 * @Version: 1.0
 */
public class Solution20230227 {

    /**
     * 来个比较稳得递归回溯吧
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum3(k, n, ans, new ArrayList<>(), 1);
        return ans;
    }

    public void combinationSum3(int k, int n, List<List<Integer>> ans, List<Integer> list, int start) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (k < 0 || n < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            combinationSum3(k - 1, n - i, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
