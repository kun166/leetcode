package com.test.leetcode.page3.chapter210.t216;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025033101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/31 17:34
 * @Version: 1.0
 */
public class Solution2025033101 {

    /**
     * 感觉得递归回溯?
     * <p>
     * 0ms	击败100.00%
     * 40.08MB	击败94.73%
     * <p>
     * 呃,我以为会超时……居然……
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, k, n, 1, new ArrayList<>());
        return ans;
    }

    void backtrack(List<List<Integer>> ans, int k, int n, int length, List<Integer> list) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (k <= 0)
            return;
        for (int i = length; i <= 9; i++) {
            if (i > n)
                return;
            list.add(i);
            backtrack(ans, k - 1, n - i, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
