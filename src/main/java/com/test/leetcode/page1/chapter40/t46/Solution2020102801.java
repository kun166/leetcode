package com.test.leetcode.page1.chapter40.t46;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-28 17:33
 */
public class Solution2020102801 {

    @Test
    public void test() {
        List<List<Integer>> result = permute(new int[]{1});
        for (List<Integer> l : result) {
            System.out.println();
            for (Integer i : l) {
                System.out.print(i + ",");
            }
        }
    }

    /**
     * 递归+回溯算法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        permute(result, list, nums, 0);
        return result;
    }

    public void permute(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <= list.size(); i++) {
            list.add(i, nums[index]);
            permute(result, list, nums, index + 1);
            list.remove(i);
        }
    }
}
