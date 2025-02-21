package com.test.leetcode.page1.chapter30.t39;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-28 14:23
 */
public class Solution20201028 {

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> list = combinationSum(candidates, 7);
        for (List<Integer> l : list) {
            System.out.println();
            for (Integer i : l) {
                System.out.print(i);
            }
        }
    }

    /**
     * 递归+回溯
     *
     * 参考{@link Solution20250221}
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum(result, list, 0, candidates, target);
        return result;
    }

    public void combinationSum(List<List<Integer>> result, List<Integer> list, int index, int[] candidates, int target) {
        for (int i = index; i < candidates.length; i++) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
                return;
            }
            if (target < 0) {
                return;
            }
            list.add(candidates[i]);
            combinationSum(result, list, i, candidates, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
