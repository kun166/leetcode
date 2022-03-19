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
public class Solution2020102802 {

    @Test
    public void test() {
        List<List<Integer>> result = permute(new int[]{1, 2, 3});
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
        //permute(result, nums, nums.length - 1);
        permuteTwo(result, nums, 0);
        return result;
    }

    public void permute(List<List<Integer>> result, int[] nums, int index) {
        if (index < 0) {
            result.add(convert(nums));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permute(result, nums, index - 1);
            swap(nums, i, index);
        }

    }

    public void permuteTwo(List<List<Integer>> result, int[] nums, int index) {
        if (index == nums.length) {
            result.add(convert(nums));
            return;
        }
        for (int i = 0; i <= index; i++) {
            swap(nums, index, i);
            permuteTwo(result, nums, index + 1);
            swap(nums, i, index);
        }

    }

    public void swap(int[] nums, int i1, int i2) {
        int m = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = m;
    }

    public List<Integer> convert(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums)
            list.add(i);
        return list;
    }
}
