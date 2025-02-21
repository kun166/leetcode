package com.test.leetcode.page1.chapter30.t39;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20250221
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/21 16:50
 * @Version: 1.0
 */
public class Solution20250221 {

    /**
     * 递归回溯,必须的
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    /**
     * 就两种情况，选择或者不选
     *
     * @param ans
     * @param candidates
     * @param target
     * @param list
     * @param index
     */
    public void backtrack(List<List<Integer>> ans, int[] candidates, int target, List<Integer> list, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        // 就两种情况,选择或者不选
        // 1,选择当前数字
        list.add(candidates[index]);
        backtrack(ans, candidates, target - candidates[index], list, index);
        list.remove(list.size() - 1);
        // 2,不选
        backtrack(ans, candidates, target, list, index + 1);
    }
}
