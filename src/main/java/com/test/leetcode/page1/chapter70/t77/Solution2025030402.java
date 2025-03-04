package com.test.leetcode.page1.chapter70.t77;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025030402
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/4 19:47
 * @Version: 1.0
 */
public class Solution2025030402 {

    /**
     * 24ms 击败31.30%
     * 92.51MB 击败58.28%
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(n, k, ans, new ArrayList<>(), 1);
        return ans;
    }

    public void backtrack(int n, int k, List<List<Integer>> ans, List<Integer> list, int index) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index > n)
            return;

        // 选择
        list.add(index);
        backtrack(n, k, ans, list, index + 1);
        list.remove(list.size() - 1);

        // 不选择
        backtrack(n, k, ans, list, index + 1);
    }
}
