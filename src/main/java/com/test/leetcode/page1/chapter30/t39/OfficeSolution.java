package com.test.leetcode.page1.chapter30.t39;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficeSolution
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/15 11:26
 * @Version: 1.0
 */
public class OfficeSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 返回结果
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 记录每一次遍历的数
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            // 说明遍历到头了
            return;
        }
        if (target == 0) {
            // 说明累加和等于目标值了
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}
