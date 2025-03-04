package com.test.leetcode.page1.chapter70.t77;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025030401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/4 19:22
 * @Version: 1.0
 */
public class Solution2025030401 {

    /**
     * 肯定是递归-回溯了
     * <p>
     * 24ms 击败31.30%
     * 92.58MB 击败45.99%
     * <p>
     * 呃，感觉效果不是很好啊……
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

        for (int i = index; i <= n; i++) {
            list.add(i);
            backtrack(n, k, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
