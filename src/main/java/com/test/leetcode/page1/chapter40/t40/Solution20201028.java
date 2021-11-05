package com.test.leetcode.page1.chapter40.t40;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-28 15:08
 */
public class Solution20201028 {

    @Test
    public void test() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> list = combinationSum2(candidates, 8);
        for (List<Integer> l : list) {
            System.out.println();
            for (Integer i : l) {
                System.out.print(i);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum2(result, list, 0, candidates, target);
        return result;
    }

    public void combinationSum2(List<List<Integer>> result, List<Integer> list, int index, int[] candidates, int target) {
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                //这个是去掉重复组合的
                continue;
            }
            if (candidates[i] == target) {
                List<Integer> l = new ArrayList<>(list);
                l.add(candidates[i]);
                result.add(l);
                return;
            }
            if (candidates[i] > target) {
                return;
            }
            list.add(candidates[i]);
            combinationSum2(result, list, i + 1, candidates, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
