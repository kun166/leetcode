package com.test.leetcode.page1.chapter40.t40;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20221011
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/11 11:23
 * @Version: 1.0
 */
public class Solution20221011 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)));
    }

    /**
     * 这道题有点意思，需求细细品味
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ant = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, ant, new ArrayList<>(), 0);
        return ant;
    }

    public void combinationSum2(int[] candidates, int target, List<List<Integer>> ant, List<Integer> list, int index) {
        if (target == 0) {
            ant.add(new ArrayList<>(list));
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
            combinationSum2(candidates, target - candidates[i], ant, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
