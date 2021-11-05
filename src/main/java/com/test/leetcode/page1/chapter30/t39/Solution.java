package com.test.leetcode.page1.chapter30.t39;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-28 10:02
 */
public class Solution {

    @Test
    public void test() {
        int[] candidates = new int[]{2, 3, 5};
        List<List<Integer>> result = combinationSum(candidates, 8);
        System.out.println(result.size());
        for (List<Integer> list : result) {
            System.out.println();
            for (Integer i : list) {
                System.out.print(i + ",");
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        combinationSum(result, candidates, target, list, 0);
        return result;
    }

    public void combinationSum(List<List<Integer>> result, int[] candidates, int target, LinkedList<Integer> list, int index) {
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] == target) {
                List l = new ArrayList(list);
                l.add(candidates[i]);
                result.add(l);
            }
            if (candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            combinationSum(result, candidates, target - candidates[i], list, i);
            list.removeLast();
        }
    }
}
