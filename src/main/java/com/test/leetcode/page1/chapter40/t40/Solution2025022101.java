package com.test.leetcode.page1.chapter40.t40;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution2025022101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/21 17:18
 * @Version: 1.0
 */
public class Solution2025022101 {

    @Test
    public void test() {
        int[] candidates = {2, 5, 2, 1, 2};
        System.out.println(JSON.toJSONString(combinationSum2(candidates, 5)));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // 不能重复,就得排序
        Arrays.sort(candidates);
        backtrack(ans, candidates, target, new ArrayList<>(), 0, true);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, int[] candidates, int target, List<Integer> list, int index, boolean preCheck) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }
        // 选择当前index位置的数
        if (index == 0 || candidates[index] != candidates[index - 1] || preCheck) {
            list.add(candidates[index]);
            backtrack(ans, candidates, target - candidates[index], list, index + 1, true);
            list.remove(list.size() - 1);
        }

        // 不选
        backtrack(ans, candidates, target, list, index + 1, false);
    }
}
