package com.test.leetcode.page1.chapter40.t40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20221109
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/9 09:49
 * @Version: 1.0
 */
public class Solution20221109 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum2(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void combinationSum2(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
