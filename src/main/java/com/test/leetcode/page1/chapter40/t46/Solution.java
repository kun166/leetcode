package com.test.leetcode.page1.chapter40.t46;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-29 20:00
 */
public class Solution {

    @Test
    public void test() {
        List<List<Integer>> result = permute(new int[]{});
        for (List<Integer> l : result) {
            System.out.println();
            for (Integer i : l) {
                System.out.print(i + ",");
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        permute(result, nums, list, set);
        return result;
    }

    public void permute(List<List<Integer>> result, int[] nums, List<Integer> list, Set<Integer> set) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            list.add(nums[i]);
            set.add(i);
            permute(result, nums, list, set);
            list.remove(list.size() - 1);
            set.remove(i);
        }
    }
}
