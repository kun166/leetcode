package com.test.leetcode.chapter40.t40;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-28 10:43
 */
public class Solution {
    @Test
    public void test() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = combinationSum2(candidates, 8);
        System.out.println(result.size());
        for (List<Integer> list : result) {
            System.out.println();
            for (Integer i : list) {
                System.out.print(i + ",");
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        combinationSum2(result, candidates, target, 0, list);
        return result;
    }

    public void combinationSum2(List<List<Integer>> result, int[] candidates, int target, int index, List<Integer> list) {
        int length = candidates.length;
        for (int i = index; i < length; i++) {
            if (candidates[i] == target) {
                List<Integer> l = new ArrayList<>(list);
                l.add(candidates[i]);
                result.add(l);
            }
            if (candidates[i] > target) break;
            list.add(candidates[i]);
            combinationSum2(result, candidates, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
