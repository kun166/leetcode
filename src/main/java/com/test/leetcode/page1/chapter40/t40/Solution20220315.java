package com.test.leetcode.page1.chapter40.t40;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20220315
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/15 14:57
 * @Version: 1.0
 */
public class Solution20220315 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);
        List<List<Integer>> ant = new ArrayList<>();
        combinationSum2(candidates, target, ant, new ArrayList<>(), 0);
        return ant;
    }

    public void combinationSum2(int[] candidates, int target, List<List<Integer>> ant, List<Integer> list, int index) {
        if (target == 0) {
            List<Integer> l = new ArrayList<>(list);
            ant.add(l);
            return;
        }
        if (index >= candidates.length || candidates[index] > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                // 保证在本次循环的时候，连续的两个数，不会同时加进list
                // 但是递归调用的时候，会把这两个相同的数加进去，只加一次？
                continue;
            }
            list.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], ant, list, i + 1);
            list.remove(list.size() - 1);
        }
    }


}
