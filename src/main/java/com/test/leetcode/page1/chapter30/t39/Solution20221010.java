package com.test.leetcode.page1.chapter30.t39;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20221010
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/10 19:56
 * @Version: 1.0
 */
public class Solution20221010 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(combinationSum(new int[]{2, 3, 6, 7}, 7)));
    }

    /**
     * 先来个递归+回溯
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ant = new ArrayList<>();
        combinationSum(candidates, target, ant, new ArrayList<>(), 0);
        return ant;
    }

    public void combinationSum(int[] candidates, int target, List<List<Integer>> ant, List<Integer> list, int index) {
        if (target == 0) {
            ant.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], ant, list, i);
            list.remove(list.size() - 1);
        }
    }
}
